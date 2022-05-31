package com.example.laboratornayaandroyd.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratornayaandroyd.dagger.DaggerAppComponent
import com.example.laboratornayaandroyd.models.Balance
import com.example.laboratornayaandroyd.models.MockApiService
import com.example.laboratornayaandroyd.models.Tariff
import com.example.laboratornayaandroyd.models.User
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
    //private var database = DaggerAppComponent.create().database()

    fun updateData() {
        viewModelScope.launch(CoroutineExceptionHandler { _, t ->
            t.printStackTrace()
        }) {
            val newTariffs = mockApiService.getTariffs()
            _tariffs.value = newTariffs
           // for (tariff in newTariffs) {
                //database.getTariffDao().save(tariff)
           // }

            val newUser = mockApiService.getUser()
            _user.value = newUser
            //database.getUserDao().save(newUser)

            val newBalance = mockApiService.getBalance()
            _balance.value = newBalance
            //database.getBalanceDao().save(newBalance)
        }
    }
}