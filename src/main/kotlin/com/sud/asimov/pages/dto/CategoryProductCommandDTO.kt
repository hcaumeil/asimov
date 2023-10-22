package com.sud.asimov.pages.dto

import com.sud.asimov.Category
import com.sud.asimov.Product

class CategoryProductCommandDTO(
        var categoryName: String,
        var quantity: List<Int>
) {
}