package com.sud.asimov;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

class ProductPost (
  var name: String,
  var category: String,
  var price: Float,
  var description: String?,
  var stock: Int,
  var reference: String,
  var image: String?,
) {
}

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    lateinit var cr : CategoryRepository;

    @Autowired
    lateinit var fr : FileRepository;

    @Autowired
    lateinit var repository : ProductRepository;

    @GetMapping()
	fun get(): List<Product> {
        return repository.findAll();
	}

    @PostMapping()
    fun post(@RequestBody product: ProductPost): Product? {    
        var p = body_to_entity(product);

        if (p == null) {
            return null
        } else {
            return repository.save(p);
        }
    }

    fun body_to_entity(body : ProductPost): Product? {
        var cats = cr.findAll();
        var files = fr.findAll();
        var image : File? = null;

        for (f in files) {
            if (f.name == body.image) {
                image = f;
            }
        }

        for (c in cats) {
            if (c.name == body.category) {
                return Product(null,body.name, c, body.price, body.description ,body.stock, body.reference, image);               
            }
        }

        return null;
    }
}