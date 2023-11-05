package com.sud.asimov.api.entities

import com.sud.asimov.Product
import com.sud.asimov.User
import jakarta.persistence.*

@Entity
class Command(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        public val id: Long? = null,
        @OneToMany
        var products: List<CartProduct>,
        @ManyToOne
        var user: User,
) {
}

