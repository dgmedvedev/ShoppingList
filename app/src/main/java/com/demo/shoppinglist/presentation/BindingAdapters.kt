package com.demo.shoppinglist.presentation

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputEditText

@BindingAdapter("errorInputName")
fun bindErrorInputName(textInputEditText: TextInputEditText, viewModel: ShopItemViewModel) {
    textInputEditText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            viewModel.resetErrorInputName()
        }
    })
}

@BindingAdapter("errorInputCount")
fun bindErrorInputCount(textInputEditText: TextInputEditText, viewModel: ShopItemViewModel) {
    textInputEditText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            viewModel.resetErrorInputCount()
        }
    })
}