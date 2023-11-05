package com.sud.asimov.api.entities

import com.sud.asimov.Product
import com.sud.asimov.User
import jakarta.persistence.*

@Entity
class CartProduct(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        public val id: Long? = null,
        @ManyToOne
        var user: User?,
        @ManyToOne
        var product: Product,
        var quantity : Long,
) {
}
