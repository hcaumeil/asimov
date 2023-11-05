package com.sud.asimov.pages

import com.sud.asimov.api.cartproduct.CartProductRepository
import com.sud.asimov.api.entities.CartProduct
import com.sud.asimov.CommandRepository
import com.sud.asimov.Command
import com.sud.asimov.pages.dto.CommandDTO
import com.sud.asimov.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.math.RoundingMode
import java.text.DecimalFormat

@Controller
class Checkout {
    @Autowired
    lateinit var repository : CartProductRepository;
    @Autowired
    lateinit var commandRepository : CommandRepository;
    @Autowired
    lateinit var userRepository : UserRepository;

    @GetMapping("/checkout/{id}")
    @Transactional
    fun checkout(@PathVariable("id") id: Long, model : Model) : String {
        val lcp = repository.findAllByUserId(id)
        var total = 0.0
        var nb = 0;
        val it = lcp.listIterator()
        while (it.hasNext()) {
            val current = it.next()
            if (current != null) {
                total += current.quantity * current.product.price
                nb++
            }
        }
        model.addAttribute("items", lcp)
        model.addAttribute("nbProduct", nb)
        model.addAttribute("total", DecimalFormat("#.##")
                .apply { roundingMode = RoundingMode.FLOOR }
                .format(total))
        return "checkout"
    }

    @PostMapping("/checkout/order")
    @Transactional
    fun orderSubmit(@RequestBody body: CommandDTO, model: Model): ResponseEntity<String> {    
        var cp = repository.findAllByUserId(body.userid)
        var products : List<CartProduct> = cp.filter { it != null } as List<CartProduct>; 
        products.map { it.user = null }

        var cmd = Command(null, products, userRepository.findById(body.userid).get(), body.name, body.family_name, body.address, body.country, body.zip_code, body.price , body.date)
        commandRepository.save(cmd)
       
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Commande pris en compte")
    }
}
