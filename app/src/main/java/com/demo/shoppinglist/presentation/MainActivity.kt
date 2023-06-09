package com.demo.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.demo.shoppinglist.R
import com.demo.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var llShopList: LinearLayout

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llShopList = findViewById(R.id.ll_shop_list)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            showShopList(it)
        }
    }

    private fun showShopList(list: List<ShopItem>) {
        llShopList.removeAllViews()
        for (shopItem in list) {
            val shopItemId = if (shopItem.enable) {
                R.layout.item_shop_enabled
            } else {
                R.layout.item_shop_disabled
            }
            val view = LayoutInflater.from(this).inflate(shopItemId, llShopList, false)
            val tvName = view.findViewById<TextView>(R.id.tv_name)
            val tvCount = view.findViewById<TextView>(R.id.tv_count)
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
            llShopList.addView(view)
            view.setOnLongClickListener {
                viewModel.changeEnableState(shopItem)
                true
            }
        }
    }
}