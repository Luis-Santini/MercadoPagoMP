package com.santini.mpgeopago.repository

import android.util.Log
import com.santini.mpgeopago.network.model.paymentMethods.PaymentMethods
import com.santini.mpgeopago.network.model.responseHadler.Resource
import com.santini.mpgeopago.network.model.responseHadler.ResponseHandler
import com.santini.mpgeopago.network.PaymentInterface
import retrofit2.HttpException

class Repository(
    private val service: PaymentInterface,
    private val responseHandler: ResponseHandler
) {

    suspend fun getAllPaymentMethods() :Resource<List<PaymentMethods>>{
        return try {
            val data = service.getAllPaymentMethods()

       //     Log.d("trae" , " Datos  ${data}")
            responseHandler.handleSuccess(data)
        }catch (e: HttpException){
            responseHandler.handleException(e)
        }
    }


}