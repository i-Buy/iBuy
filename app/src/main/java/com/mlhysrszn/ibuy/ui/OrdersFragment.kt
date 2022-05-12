package com.mlhysrszn.ibuy.ui

import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentOrdersBinding


class OrdersFragment : BaseFragment<FragmentOrdersBinding>() {

    override fun layoutId(): Int = R.layout.fragment_orders

    override fun initUI() {

        binding.toolbarOrder.inflateMenu(R.menu.toolbar_order)
        binding.toolbarOrder.setLogo(R.drawable.ic_arrow_back)
        binding.toolbarOrder.title = " Orders"
    }
}