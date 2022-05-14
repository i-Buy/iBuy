package com.mlhysrszn.ibuy.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("intText")
fun TextView.intText(value: Int) {
    text = value.toString()
}