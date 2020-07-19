package com.santini.mpgeopago.network.model.paymentMethods


import com.google.gson.annotations.SerializedName

data class SecurityCode(
    @SerializedName("card_location")
    val cardLocation: String,
    @SerializedName("length")
    val length: Int,
    @SerializedName("mode")
    val mode: String
)