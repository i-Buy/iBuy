package com.mlhysrszn.ibuy.ui

import com.bumptech.glide.Glide
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.databinding.FragmentDetailBinding


class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    override fun layoutId(): Int = R.layout.fragment_detail

    override fun initUI() {

        lateinit var product: Product
        arguments?.let {
            product = DetailFragmentArgs.fromBundle(it).product
            binding.product = product
        }
        if (product.status == 1) {
            binding.buttonAddBasket.text = "Remove from basket"
        }
        Glide.with(requireContext()).load(product.image).into(binding.imageViewProductImage)
    }
}