package com.mlhysrszn.ibuy.ui.shoppingcard

import androidx.fragment.app.viewModels
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentShoppingCardBinding
import com.mlhysrszn.ibuy.ui.shoppingcard.adapter.ShoppingCardAdapter

class ShoppingCardFragment : BaseFragment<FragmentShoppingCardBinding>() {

    private lateinit var adapter: ShoppingCardAdapter
    private val viewModel: ShoppingCardViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_shopping_card

    override fun initUI() {
        viewModel.shoppingCardList.observe(viewLifecycleOwner) {
            adapter = ShoppingCardAdapter(it)
            binding.rvShoppingCard.adapter = adapter
        }
    }
}
