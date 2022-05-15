package com.mlhysrszn.ibuy.ui.shoppingcard

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.data.local.AppDatabase
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import com.mlhysrszn.ibuy.databinding.FragmentShoppingCardBinding
import com.mlhysrszn.ibuy.ui.shoppingcard.adapter.ShoppingCardAdapter
import com.mlhysrszn.ibuy.utils.ApiStatus

class ShoppingCardFragment : BaseFragment<FragmentShoppingCardBinding>() {

    override fun layoutId(): Int = R.layout.fragment_shopping_card

    override fun initUI() {
        val productsDao by lazy {
            AppDatabase.getFavoritesDatabase(requireContext())?.productsDao()
        }
        val repository = ProductRepository(productsDao)
        val viewModel: ShoppingCardViewModel by viewModels {
            ShoppingCardViewModelFactory(repository)
        }
        val adapter: ShoppingCardAdapter by lazy { ShoppingCardAdapter(viewModel) }

        viewModel.shoppingCardList.observe(viewLifecycleOwner) {
            when (it) {
                is ApiStatus.Success -> {
                    adapter.productsList = it.data
                    binding.rvShoppingCard.adapter = adapter
                    binding.progressBar.visibility = View.GONE
                }
                is ApiStatus.Error -> {
                    binding.progressBar.visibility = View.VISIBLE
                    println(it.message)
                }
                is ApiStatus.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }

        adapter.onRootClick = {
            val action =
                ShoppingCardFragmentDirections.actionShoppingCardFragmentToDetailFragment(it)
            requireView().findNavController().navigate(action)
        }
    }
}
