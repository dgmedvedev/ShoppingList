package com.demo.shoppinglist.presentation

import android.app.Application
import com.demo.shoppinglist.di.DaggerApplicationComponent

class ShopApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}