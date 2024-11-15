package com.example.celebrity.model.entity

import java.util.UUID
import com.google.gson.annotations.SerializedName

data class Celebrity(
    val name: String? = null,
    val gender: String? = null,
    @SerializedName("net_worth") val netWorth: Int? = null,
    val nationality: String? = null,
    val occupation: List<String>? = null,
    val birthday: String? = null,
    val height: Double? = null,
)