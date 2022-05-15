package com.mlhysrszn.ibuy.ui.home

import android.view.View
import androidx.fragment.app.viewModels
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.data.local.AppDatabase
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import com.mlhysrszn.ibuy.databinding.FragmentHomeBinding
import com.mlhysrszn.ibuy.ui.home.adapter.ProductAdapter
import com.mlhysrszn.ibuy.utils.ApiStatus

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val adapter: ProductAdapter by lazy { ProductAdapter() }

    override fun layoutId(): Int = R.layout.fragment_home

    override fun initUI() {
        val productsDao by lazy {
            AppDatabase.getFavoritesDatabase(requireContext())?.productsDao()
        }
        val repository = ProductRepository(productsDao)
        val viewModel: HomeViewModel by viewModels {
            HomeViewModelFactory(repository)
        }

        viewModel.productsList.observe(viewLifecycleOwner) {
            when (it) {
                is ApiStatus.Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.productsList = it.data
                    binding.rvProducts.adapter = adapter
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

        adapter.onClick = {
            println(it.id)
            println(it.price)
            println(it.category)
            println(it.name)
        }
    }
}