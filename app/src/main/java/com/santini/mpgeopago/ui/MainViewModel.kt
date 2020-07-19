package com.santini.mpgeopago.ui

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.*
import com.santini.mpgeopago.network.model.paymentMethods.PaymentMethods
import com.santini.mpgeopago.network.model.responseHadler.Resource
import com.santini.mpgeopago.network.model.responseHadler.Resource.Companion
import com.santini.mpgeopago.network.model.responseHadler.Resource.Status.SUCCESS
import com.santini.mpgeopago.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _loadingVisibility = MutableLiveData<Int>(GONE)
    val loadingVisibility: LiveData<Int> get() = _loadingVisibility

    private val _paymentMethods = MutableLiveData<List<PaymentMethods>>()
    val paymentMethods: LiveData<List<PaymentMethods>> get() = _paymentMethods

    private val _errorVisibility = MutableLiveData<Int>(GONE)
    val errorVisibility: LiveData<Int> get() = _errorVisibility

    private val _recycleVisibility = MutableLiveData<Int>(GONE)
    val recycleVisibility: LiveData<Int> get() = _recycleVisibility

    fun getpaymentMethods() {
        //  liveData(Dispatchers.IO)
        viewModelScope.launch {
            withContext(IO) {
                _loadingVisibility.postValue(VISIBLE)
                val result = repository.getAllPaymentMethods()
                if (result.status == SUCCESS) {
                    val data = result.data
                    data?.let {
                        _paymentMethods.postValue(it)
                        if (it.isEmpty()){
                            _recycleVisibility.postValue(GONE)
                        }
                    }
                    _loadingVisibility.postValue(GONE)
                }else{
                    _errorVisibility.postValue(VISIBLE)
                    _loadingVisibility.postValue(GONE)
                    _errorVisibility.postValue(GONE)
                }
            }
        }
    }


}