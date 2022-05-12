package com.mlhysrszn.ibuy.ui

import android.widget.PopupMenu
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentSettingsBinding

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    override fun layoutId(): Int = R.layout.fragment_settings

    override fun initUI() {

        val popup = PopupMenu(requireContext(), binding.textViewReigon)
        popup.menuInflater.inflate(R.menu.popup_settings, popup.menu)

        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_greece -> {
                    binding.textViewReigon.text = getString(R.string.greece)
                    true
                }
                R.id.action_bulgaria -> {
                    binding.textViewReigon.text = getString(R.string.bulgaria)
                    true
                }
                R.id.action_turkey -> {
                    binding.textViewReigon.text = getString(R.string.turkey)
                    true
                }
                R.id.action_romania -> {
                    binding.textViewReigon.text = getString(R.string.romania)
                    true
                }
                else -> false
            }
        }
    }
}
