package com.mlhysrszn.ibuy.ui


import android.widget.Toast
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentEditprofileBinding


class EditProfileFragment : BaseFragment<FragmentEditprofileBinding>() {

    override fun layoutId(): Int = R.layout.fragment_editprofile

    override fun initUI() {
        binding.button.setOnClickListener {

            Toast.makeText(activity, "Changes Applied", Toast.LENGTH_SHORT).show()
        }
    }
}
