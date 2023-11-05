package com.sud.asimov;

import com.sud.asimov.pages.dto.ProductAddDTO
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var name: String,
        @ManyToOne
        var category: Category,
        var price: Float,
        var description: String?,
        var stock: Int,
        var reference: String,
        @OneToOne
        var image: File?,
) {
}
