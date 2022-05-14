package com.mlhysrszn.ibuy.ui.home

import android.view.View
import androidx.fragment.app.viewModels
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentHomeBinding
import com.mlhysrszn.ibuy.ui.home.adapter.ProductAdapter
import com.mlhysrszn.ibuy.utils.ApiStatus

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var adapter: ProductAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_home

    override fun initUI() {
        viewModel.productsList.observe(viewLifecycleOwner) {
            when (it) {
                is ApiStatus.Success -> {
                    binding.progressBar.visibility = View.GONE
                    adapter = ProductAdapter(it.data)
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
            /*
            adapter = ProductAdapter(it)
            binding.rvProducts.adapter = adapter

             */
        }
    }
}