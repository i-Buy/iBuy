package com.mlhysrszn.ibuy.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mlhysrszn.ibuy.data.local.entity.ProductEntity

@Dao
interface ProductsDao {

    @Query("SELECT * FROM products")
    fun getAllFavProducts(): List<ProductEntity>

    @Insert
    fun insertFavProduct(favProduct: ProductEntity)

    @Delete
    fun deleteFavProduct(favProduct: ProductEntity)

    @Query("SELECT * FROM products WHERE id = :productId")
    fun getFavProduct(productId: Int): ProductEntity?
}
