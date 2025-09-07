package com.example.jello.utils.retrofit

import com.example.remote.model.base.NetworkResource
import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response

class NetworkResourceCall<V: Any, T: Any>(
    private val proxy: Call<V>,
    private val errorConverter: Converter<ResponseBody, T>
): Call<NetworkResource<V, T>> {

    override fun execute(): Response<NetworkResource<V, T>?> {
        TODO("Not yet implemented")
    }

    override fun enqueue(p0: Callback<NetworkResource<V, T>?>) {
        TODO("Not yet implemented")
    }

    override fun isExecuted(): Boolean {
        TODO("Not yet implemented")
    }

    override fun cancel() {
        TODO("Not yet implemented")
    }

    override fun isCanceled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun clone(): Call<NetworkResource<V, T>?> {
        TODO("Not yet implemented")
    }

    override fun request(): Request {
        TODO("Not yet implemented")
    }

    override fun timeout(): Timeout {
        TODO("Not yet implemented")
    }

}