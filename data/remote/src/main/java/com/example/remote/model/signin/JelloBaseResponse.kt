package com.example.remote.model.signin


import com.google.gson.annotations.SerializedName

data class JelloBaseResponse<T>(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: T?,
)