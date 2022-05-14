package com.mlhysrszn.ibuy.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentBestShopMessageBinding


class BestShopMessageFragment : BaseFragment<FragmentBestShopMessageBinding>() {
    override fun layoutId(): Int = R.layout.fragment_best_shop_message


    @SuppressLint("SetTextI18n")
    override fun initUI() {
        binding.buttonBestShopRead.setOnClickListener {
            binding.imageViewReadBestShop.setImageResource(R.drawable.ic_email_unread)
            binding.buttonBestShopRead.setText("Mark as Read")
        }
    }

}