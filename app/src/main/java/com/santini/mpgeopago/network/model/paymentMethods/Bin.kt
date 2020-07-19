package com.santini.mpgeopago.network.model.paymentMethods


import com.google.gson.annotations.SerializedName

data class Bin(
    @SerializedName("exclusion_pattern")
    val exclusionPattern: String,
    @SerializedName("installments_pattern")
    val installmentsPattern: String,
    @SerializedName("pattern")
    val pattern: String
)