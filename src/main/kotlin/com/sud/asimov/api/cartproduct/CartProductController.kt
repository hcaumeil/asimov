package com.sud.asimov.api.cartproduct

import com.sud.asimov.Category
import com.sud.asimov.CategoryRepository
import com.sud.asimov.api.entities.CartProduct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cart-product")
class CartProductController {
    @Autowired
    lateinit var repository : CartProductRepository;

    @GetMapping()
    fun get(): List<CartProduct> {
        return repository.findAll();
    }

    @PostMapping()
    fun post(@RequestBody cartProduct: CartProduct): CartProduct {
        return repository.save(cartProduct);
    }
}