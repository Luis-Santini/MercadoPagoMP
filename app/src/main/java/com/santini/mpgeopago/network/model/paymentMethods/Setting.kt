package com.santini.mpgeopago.network.model.paymentMethods


import com.google.gson.annotations.SerializedName

data class Setting(
    @SerializedName("bin")
    val bin: Bin,
    @SerializedName("card_number")
    val cardNumber: CardNumber,
    @SerializedName("security_code")
    val securityCode: SecurityCode
)