package com.mlhysrszn.ibuy.ui

import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentDetailBinding


class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    override fun layoutId(): Int = R.layout.fragment_detail

    override fun initUI() {

        binding.imageAddFav.setOnClickListener{
            binding.imageAddFav.setColorFilter(android.R.color.holo_red_dark)
        }
    }
}