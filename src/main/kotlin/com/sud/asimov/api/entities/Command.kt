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
        public var products: List<CartProduct>,
        @ManyToOne
        public var user: User,

        public var name: String,
        public var family_name: String,
        public var address: String,
        public var country: String,
        public var zip_code: String,
        public var price: Float,
        public var date: String,
) {
}

