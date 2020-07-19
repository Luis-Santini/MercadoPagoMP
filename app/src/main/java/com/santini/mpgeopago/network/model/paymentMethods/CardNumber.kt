package com.santini.mpgeopago.network.model.paymentMethods


import com.google.gson.annotations.SerializedName

data class CardNumber(
    @SerializedName("length")
    val length: Int,
    @SerializedName("validation")
    val validation: String
)