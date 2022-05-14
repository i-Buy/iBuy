package com.mlhysrszn.ibuy.ui

import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentSettingsBinding
import kotlin.properties.Delegates

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    override fun layoutId(): Int = R.layout.fragment_settings



    override fun initUI() {

        /*val popup = PopupMenu(activity, binding.buttonReigon)
        popup.menuInflater.inflate(R.menu.popup_settings, popup.menu)

        binding.buttonReigon.setOnClickListener {
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_greece -> {
                        binding.buttonReigon.text = getString(R.string.greece)
                        true
                    }
                    R.id.action_bulgaria -> {
                        binding.buttonReigon.text = getString(R.string.bulgaria)
                        true
                    }
                    R.id.action_turkey -> {
                        binding.buttonReigon.text = getString(R.string.turkey)
                        true
                    }
                    R.id.action_romania -> {
                        binding.buttonReigon.text = getString(R.string.romania)
                        true
                    }
                    else -> false
                }

         */

        for (i in 0..100000) {

            binding.buttonReigon.setOnClickListener {

                if (binding.buttonReigon.text == getString(R.string.turkey)) {
                    binding.buttonReigon.setText(R.string.greece)
                }

                if (binding.buttonReigon.text == getString(R.string.greece)) {
                    binding.buttonReigon.setText(R.string.romania)
                }

                if (binding.buttonReigon.text == getString(R.string.romania)) {
                    binding.buttonReigon.setText(R.string.bulgaria)
                }

                if (binding.buttonReigon.text == getString(R.string.bulgaria)) {
                    binding.buttonReigon.setText(R.string.turkey)
                }
            }
        }

    }
}
