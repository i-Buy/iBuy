package com.mlhysrszn.ibuy.data.model

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val inStock: Short,
    val quantityPerUnit: Int, // String
    val category: Category
)