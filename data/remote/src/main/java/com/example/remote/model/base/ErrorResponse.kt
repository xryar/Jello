package com.example.remote.model.base

data class ErrorResponse(
    @SerializedName("code")
    val code:  Int ? = null,

    @SerializedName("message")
    val message:  String? = null,
)