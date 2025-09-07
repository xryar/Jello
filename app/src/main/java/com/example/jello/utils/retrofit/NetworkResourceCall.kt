package com.example.jello.utils.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Converter

class NetworkResourceCall<V: Any, T: Any>(
    private val proxy: Call<V>,
    private val errorConverter: Converter<ResponseBody, T>
): Call<NetworkResource<V, T>> {

}