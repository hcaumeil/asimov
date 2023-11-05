package com.sud.asimov

import com.sud.asimov.Product
import com.sud.asimov.User
import com.sud.asimov.api.entities.CartProduct
import jakarta.persistence.*

@Entity
class Command(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        public val id: Long? = null,
        @OneToMany
        var products: List<CartProduct>,
        @ManyToOne
        var user: User,

        var name: String,
        var family_name: String,
        var address: String,
        var country: String,
        var zip_code: String,
) {
}

