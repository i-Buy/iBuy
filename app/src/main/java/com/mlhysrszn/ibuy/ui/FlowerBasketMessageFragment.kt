package com.mlhysrszn.ibuy.ui

import android.annotation.SuppressLint
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentFlowerBasketMessageBinding


class FlowerBasketMessageFragment : BaseFragment<FragmentFlowerBasketMessageBinding>() {
    override fun layoutId(): Int = R.layout.fragment_flower_basket_message

    @SuppressLint("SetTextI18n")
    override fun initUI() {

            binding.buttonFlowerRead.setOnClickListener {
            binding.imageViewReadF.setImageResource(R.drawable.ic_email_unread)
            binding.buttonFlowerRead.text = "Mark as Read"
        }
    }
}

