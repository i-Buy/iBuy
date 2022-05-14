package com.mlhysrszn.ibuy.ui.shoppingcard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mlhysrszn.ibuy.data.model.Product

class ShoppingCardViewModel: ViewModel() {

    private val _shoppingCardList = MutableLiveData<List<Product>>()
    val shoppingCardList: LiveData<List<Product>>
        get() = _shoppingCardList

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        /*
        _shoppingCardList.value = arrayListOf(
            Product(1, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(2, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(3, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(4, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(5, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(6, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(7, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(8, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(9, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(10, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(11, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(12, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(13, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(14, "Computer", 9999.99, 5, "1", Category(1, "Technology")),
            Product(15, "Computer", 9999.99, 5, "1", Category(1, "Technology"))
        )

         */
    }
}