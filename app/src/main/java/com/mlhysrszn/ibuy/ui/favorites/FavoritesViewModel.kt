package com.mlhysrszn.ibuy.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlhysrszn.ibuy.data.model.Product

class FavoritesViewModel: ViewModel() {

    private val _favoritesList = MutableLiveData<List<Product>>()
    val favoritesList: LiveData<List<Product>>
        get() = _favoritesList

    init {
        getAllFavProducts()
    }

    private fun getAllFavProducts(){
        /*
        _favoritesList.value = arrayListOf(
            Product(1, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(2, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(3, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(4, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(5, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(6, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(7, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(8, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(9, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(10, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(11, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(12, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(13, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(14, "Book", 9999.99, 5, "1", Category(1, "Stationery")),
            Product(15, "Book", 9999.99, 5, "1", Category(1, "Stationery"))
        )

         */
    }
}