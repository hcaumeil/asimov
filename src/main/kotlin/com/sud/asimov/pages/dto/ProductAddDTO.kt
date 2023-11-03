package com.sud.asimov.pages.dto

import com.sud.asimov.Category
import jakarta.persistence.ManyToOne

class ProductAddDTO(
        var name: String,
        var category: String,
        var price: Float,
        var description: String?,
        var stock: Int,
        var reference: String,
        // Add file
) {
}