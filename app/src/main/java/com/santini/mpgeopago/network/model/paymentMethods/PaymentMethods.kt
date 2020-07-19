package com.santini.mpgeopago.network.model.paymentMethods


import com.google.gson.annotations.SerializedName

data class PaymentMethods(
    @SerializedName("accreditation_time")
    val accreditationTime: Int,
    @SerializedName("additional_info_needed")
    val additionalInfoNeeded: List<String>,
    @SerializedName("deferred_capture")
    val deferredCapture: String,
   /* @SerializedName("financial_institutions")
    val financialInstitutions: List<Any>,*/
    @SerializedName("id")
    val id: String,
    @SerializedName("max_allowed_amount")
    val maxAllowedAmount: Double,
    @SerializedName("min_allowed_amount")
    val minAllowedAmount: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("payment_type_id")
    val paymentTypeId: String,
    @SerializedName("processing_modes")
    val processingModes: List<String>,
    @SerializedName("secure_thumbnail")
    val secureThumbnail: String,
    @SerializedName("settings")
    val settings: List<Setting>,
    @SerializedName("status")
    val status: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)