package com.demo.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.demo.shoppinglist.data.ShopListRepositoryImpl
import com.demo.shoppinglist.domain.DeleteShopItemUseCase
import com.demo.shoppinglist.domain.EditShopItemUseCase
import com.demo.shoppinglist.domain.GetShopListUseCase

class MainViewModel() : ViewModel() {

    private val repository =
        ShopListRepositoryImpl // изучить инъекцию зависимостей  сделать правильно

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
}