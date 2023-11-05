package com.sud.asimov.pages

import com.sud.asimov.*
import com.sud.asimov.pages.dto.ProductAddDTO
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class Merchant {
    @Autowired
    lateinit var categoryRepository : CategoryRepository;

    @Autowired
    lateinit var productsRepository : ProductRepository;

    @Autowired
    lateinit var fileRepository : FileRepository;

    @GetMapping("/merchant")
    fun admin(model : Model) : String {
        // Check creditials
        // return 403

        model.addAttribute("products", productsRepository.findAll())
        model.addAttribute("categories", categoryRepository.findAll())
        return "merchant"
    }

    @GetMapping("/merchant/fragment/product")
    fun showProductPart(model : Model) : String {
        model.addAttribute("products", productsRepository.findAll())
        model.addAttribute("categories", categoryRepository.findAll())
        return "merchant :: #merchant-products-list"
    }


    @PostMapping("/merchant/delete/product")
    @Transactional
    fun productDeleteSubmit(@RequestBody productId : Long, model: Model): ResponseEntity<String> {
        productsRepository.deleteById(productId)
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Produit supprimé")
    }

    @PostMapping("/merchant/add/product")
    @Transactional
    fun productAddSubmit(@RequestBody product : ProductAddDTO, model: Model): ResponseEntity<String> {
        var files = fileRepository.findAll();
        var image : File? = null;

        for (f in files) {
            if (f.name == product.image) {
                image = f;
                break;
            }
        }

        if (image == null) {
            return ResponseEntity.badRequest()
                    .body("L'image du produit n'a pas été trouvée");
        }

        productsRepository.save(Product(null,
                product.name,
                Category(product.category),
                product.price,
                product.description,
                product.stock,
                product.reference,
                image))
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Produit ajouté")
    }
}