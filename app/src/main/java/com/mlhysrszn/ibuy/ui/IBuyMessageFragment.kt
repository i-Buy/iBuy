package com.mlhysrszn.ibuy.ui

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentIBuyMessageBinding


class IBuyMessageFragment : BaseFragment<FragmentIBuyMessageBinding>() {
    override fun layoutId(): Int = R.layout.fragment_i_buy_message



    @SuppressLint("SetTextI18n")
    override fun initUI() {

    binding.buttonIBuyRead.setOnClickListener {
        binding.imageViewReadIBuy.setImageResource(R.drawable.ic_email_unread)
        binding.buttonIBuyRead.setText("Mark as Read")
    }

    }


}