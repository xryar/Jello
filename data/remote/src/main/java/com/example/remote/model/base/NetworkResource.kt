package com.example.remote.model.base

import java.io.IOException

sealed class NetworkResource<out V: Any, out T: Any> {

    // API Success
    data class NetworkSuccess<V: Any>(val data: V?): NetworkResource<V, Nothing>()

    // API Error
    data class NetworkApiError<T: Any>(val errData: T?, val code: Int): NetworkResource<Nothing, T>()

    // Network Issue
    data class NetworkError(val error: IOException): NetworkResource<Nothing, Nothing>()

    // Parsing JSON Error
    data class NetworkUnknowError(val throwable: Throwable): NetworkResource<Nothing, Nothing>()
}