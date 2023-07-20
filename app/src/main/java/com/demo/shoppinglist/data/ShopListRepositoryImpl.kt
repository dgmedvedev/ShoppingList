package com.demo.shoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.demo.shoppinglist.domain.ShopItem
import com.demo.shoppinglist.domain.ShopListRepository

class ShopListRepositoryImpl(application: Application) : ShopListRepository {

    private val shopListDao = AppDatabase.getInstance(application).shopListDao()
    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
    }

    override fun editShopItem(shopItem: ShopItem) {
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
    }

    private fun updateList() {
    }
}