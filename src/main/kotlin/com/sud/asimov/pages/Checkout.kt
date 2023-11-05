package com.sud.asimov.pages

import com.sud.asimov.api.cartproduct.CartProductRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.math.RoundingMode
import java.text.DecimalFormat

@Controller
class Checkout {
    @Autowired
    lateinit var repository : CartProductRepository;
    @GetMapping("/checkout/{id}")
    @Transactional
    fun checkout(@PathVariable("id") id: Long, model : Model) : String {
        val lcp = repository.findAllByUserId(id)
        var total = 0.0
        val it = lcp.listIterator()
        while (it.hasNext()) {
            val current = it.next()
            if (current != null) {
                total += current.quantity * current.product.price
            }
        }
        model.addAttribute("items", lcp)
        model.addAttribute("total", DecimalFormat("#.##")
                .apply { roundingMode = RoundingMode.FLOOR }
                .format(total))
        return "checkout"
    }
}