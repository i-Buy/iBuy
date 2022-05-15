package com.mlhysrszn.ibuy.ui.home

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.data.local.AppDatabase
import com.mlhysrszn.ibuy.data.local.entity.ProductEntity
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import com.mlhysrszn.ibuy.databinding.FragmentHomeBinding
import com.mlhysrszn.ibuy.ui.home.adapter.ProductAdapter
import com.mlhysrszn.ibuy.utils.ApiStatus

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun layoutId(): Int = R.layout.fragment_home

    override fun initUI() {

        val productsDao by lazy {
            AppDatabase.getFavoritesDatabase(requireContext())?.productsDao()
        }
        val repository = ProductRepository(productsDao)
        val viewModel: HomeViewModel by viewModels {
            HomeViewModelFactory(repository)
        }
        val adapter: ProductAdapter by lazy { ProductAdapter(viewModel) }

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

        adapter.onRootClick = {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it)
            requireView().findNavController().navigate(action)
        }

        adapter.onClick = {
            if (viewModel.isFavorite(it.id)) {
                viewModel.deleteFromFav(
                    ProductEntity(
                        it.id,
                        it.name,
                        it.price,
                        it.inStock,
                        it.status,
                        it.category,
                        it.image
                    )
                )
            } else {
                viewModel.addToFav(
                    ProductEntity(
                        it.id,
                        it.name,
                        it.price,
                        it.inStock,
                        it.status,
                        it.category,
                        it.image
                    )
                )
            }
            viewModel.productsList.observe(viewLifecycleOwner) { status ->
                when (status) {
                    is ApiStatus.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.productsList = status.data
                        binding.rvProducts.adapter = adapter
                    }
                    is ApiStatus.Error -> {
                        binding.progressBar.visibility = View.VISIBLE
                        println(status.message)
                    }
                    is ApiStatus.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}