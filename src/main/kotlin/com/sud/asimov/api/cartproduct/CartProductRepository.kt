package com.sud.asimov.api.cartproduct

import com.sud.asimov.api.entities.CartProduct
import org.springframework.data.jpa.repository.JpaRepository

interface CartProductRepository : JpaRepository<CartProduct, Long> {
    fun findByUser_Id(user: Long): CartProduct?
    fun findAllByUserId(userId: Long) : List<CartProduct?>
    fun deleteCartProductByProductId(productId: Long)
}