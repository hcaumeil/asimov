package com.sud.asimov.api.cartproduct

import com.sud.asimov.Category
import com.sud.asimov.User
import com.sud.asimov.api.entities.CartProduct
import org.springframework.data.jpa.repository.JpaRepository

interface CartProductRepository : JpaRepository<CartProduct, String> {
    fun findByUser_Id(user: Long): CartProduct?
}