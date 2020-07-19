package com.santini.mpgeopago.network

import com.santini.mpgeopago.common.Constants.Companion.PUBLIC_KEY
import com.santini.mpgeopago.network.model.paymentMethods.PaymentMethods
import retrofit2.http.GET
import retrofit2.http.Query

interface PaymentInterface {
    @GET("payment_methods")
    suspend fun getAllPaymentMethods(@Query("public_key") key: String = PUBLIC_KEY): List<PaymentMethods>
}