package com.mlhysrszn.ibuy.ui.shoppingcard

import androidx.core.graphics.drawable.toDrawable
import androidx.navigation.findNavController
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentMessagesBinding


class MessagesFragment : BaseFragment<FragmentMessagesBinding>() {
    override fun layoutId(): Int = R.layout.fragment_messages


    override fun initUI() {
        binding.constraintLayoutIBuy.setOnClickListener {
            it.findNavController().navigate(R.id.messagesToIBuy)
            binding.imageViewReadI.setImageDrawable(R.drawable.ic_email_read.toDrawable())
        }

        binding.constraintLayoutBestShop.setOnClickListener {
            it.findNavController().navigate(R.id.messagesToBestShop)
            binding.imageViewReadI.setImageDrawable(R.drawable.ic_email_read.toDrawable())
        }

        binding.constraintLayoutFlowerBasket.setOnClickListener {
            it.findNavController().navigate(R.id.messagesToFlowerBasket)
            binding.imageViewReadI.setImageDrawable(R.drawable.ic_email_read.toDrawable())
        }
    }

}