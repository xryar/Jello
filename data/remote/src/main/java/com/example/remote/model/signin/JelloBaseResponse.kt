package com.example.remote.model.signin


import com.google.gson.annotations.SerializedName

data class JelloBaseResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val data: JelloBaseResponse?,
    @SerializedName("message")
    val message: String?
)