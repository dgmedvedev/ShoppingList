package com.demo.shoppinglist.presentation.adapters

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import com.demo.shoppinglist.R
import com.demo.shoppinglist.presentation.ShopItemViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorInputName")
fun bindErrorInputName(textInputLayout: TextInputLayout, isError: Boolean) {
    val message = if (isError) {
        textInputLayout.context.getString(R.string.error_input_name)
    } else {
        null
    }
    textInputLayout.error = message
}

@BindingAdapter("errorInputCount")
fun bindErrorInputCount(textInputLayout: TextInputLayout, isError: Boolean) {
    val message = if (isError) {
        textInputLayout.context.getString(R.string.error_input_count)
    } else {
        null
    }
    textInputLayout.error = message
}

@BindingAdapter("resetErrorInputName")
fun bindResetErrorInputName(textInputEditText: TextInputEditText, viewModel: ShopItemViewModel) {
    textInputEditText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            viewModel.resetErrorInputName()
        }
    })
}

@BindingAdapter("resetErrorInputCount")
fun bindResetErrorInputCount(textInputEditText: TextInputEditText, viewModel: ShopItemViewModel) {
    textInputEditText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            viewModel.resetErrorInputCount()
        }
    })
}