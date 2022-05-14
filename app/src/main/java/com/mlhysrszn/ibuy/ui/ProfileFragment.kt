package com.mlhysrszn.ibuy.ui

import androidx.navigation.findNavController
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override fun layoutId(): Int = R.layout.fragment_profile

    override fun initUI() {

        binding.toolbar.inflateMenu(R.menu.menu_profile)

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_edit -> {
                    val action = ProfileFragmentDirections.profileToEditProfile()
                    requireView().findNavController().navigate(action)
                }
                R.id.action_settings -> {
                    val action = ProfileFragmentDirections.profileToSettings()
                    requireView().findNavController().navigate(action)
                }

                R.id.action_notifications->{
                    val action = ProfileFragmentDirections.profileToNotifications()
                    requireView().findNavController().navigate(action)
                }
            }
            true
        }

        binding.buttonYourOrders.setOnClickListener {
            it.findNavController().navigate(R.id.profileToOrder)
        }


        binding.buttonYourMessages.setOnClickListener {
            it.findNavController().navigate(R.id.profileToMessages)
        }

        binding.buttonYourCoupons.setOnClickListener {
            it.findNavController().navigate(R.id.profileToCoupons)
        }

        binding.buttonOrderAgain.setOnClickListener {
            it.findNavController().navigate(R.id.profileToAgainOrder)
        }

    }

    /*
    fun setNotificationVisibility(visibility: Boolean){
        val menu = binding.toolbar.menu
        if (visibility == true) {
            menu.findItem(R.id.aciton_notifications).isVisible = true
        } else {
            menu.findItem(R.id.aciton_notifications).isVisible = false
        }
    }
     */
}