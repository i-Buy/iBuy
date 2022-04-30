package com.mlhysrszn.ibuy.ui.home

import androidx.fragment.app.viewModels
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentHomeBinding
import com.mlhysrszn.ibuy.ui.home.adapter.ProductAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var adapter: ProductAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_home

    override fun initUI() {
        viewModel.productsList.observe(viewLifecycleOwner) {
            adapter = ProductAdapter(it)
            binding.rvProducts.adapter = adapter
        }
    }
}