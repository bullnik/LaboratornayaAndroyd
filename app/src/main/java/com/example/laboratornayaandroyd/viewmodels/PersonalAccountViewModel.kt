package com.example.laboratornayaandroyd.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratornayaandroyd.dagger.DaggerAppComponent
import com.example.laboratornayaandroyd.models.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class PersonalAccountViewModel : ViewModel() {

    private var _user = MutableLiveData<User>()
    private var _tariffs = MutableLiveData<List<Tariff>>()
    private var _balance = MutableLiveData<Balance>()

    val user: LiveData<User> = _user
    val tariffs: LiveData<List<Tariff>> = _tariffs
    val balance: LiveData<Balance> = _balance

    private var mockApiService = DaggerAppComponent.create().mockApiService

    fun updateData() {
        viewModelScope.launch(CoroutineExceptionHandler { _, t ->
            t.printStackTrace()
        }) {
            val newTariffs = mockApiService.getTariffs()
            _tariffs.value = newTariffs

            val newUser = mockApiService.getUser()
            _user.value = newUser

            val newBalance = mockApiService.getBalance()
            _balance.value = newBalance
        }
    }
}