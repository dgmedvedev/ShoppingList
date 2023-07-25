package com.demo.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.demo.shoppinglist.data.ShopListRepositoryImpl
import com.demo.shoppinglist.domain.DeleteShopItemUseCase
import com.demo.shoppinglist.domain.EditShopItemUseCase
import com.demo.shoppinglist.domain.GetShopListUseCase
import com.demo.shoppinglist.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository =
        ShopListRepositoryImpl(application) // изучить инъекцию зависимостей  сделать правильно

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    private val scope = CoroutineScope(Dispatchers.IO)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        scope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeEnableState(shopItem: ShopItem) {
        scope.launch {
            val newItem = shopItem.copy(enable = !shopItem.enable)
            editShopItemUseCase.editShopItem(newItem)
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}