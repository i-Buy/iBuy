package com.mlhysrszn.ibuy.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val price: Int,
    val inStock: Int,
    val status: Int,
    val category: String,
    val image: String
)
