package com.example.jello.utils.retrofit

import com.example.remote.model.base.NetworkResource
import okhttp3.Request
import okhttp3.ResponseBody
import okio.IOException
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.lang.Exception

class NetworkResourceCall<V: Any, T: Any>(
    private val proxy: Call<V>,
    private val errorConverter: Converter<ResponseBody, T>
): Call<NetworkResource<V, T>> {

    override fun execute(): Response<NetworkResource<V, T>?> {
        throw UnsupportedOperationException("NetworkResourceCall doesn't support execute")
    }

    override fun enqueue(callback: Callback<NetworkResource<V, T>>) {
        proxy.enqueue(object: Callback<V> {
            override fun onResponse(call: Call<V>, response: Response<V>) {
                val code = response.code()
                val body = response.body()
                val error = response.errorBody()

                if (response.isSuccessful) {
                    if (body != null) {
                        callback.onResponse(
                            this@NetworkResourceCall,
                            Response.success(NetworkResource.NetworkSuccess(body))
                        )
                    } else {
                        callback.onResponse(
                            this@NetworkResourceCall,
                            Response.success(NetworkResource.NetworkUnknowError(null))
                        )
                    }
                } else {
                    val errorBody = when {
                        error == null -> null
                        error.contentLength() == 0L -> null
                        else -> try {
                            errorConverter.convert(error)
                        } catch (e: Exception) {
                            null
                        }
                    }

                    if (errorBody != null) {
                        callback.onResponse(
                            this@NetworkResourceCall,
                            Response.success(NetworkResource.NetworkApiError(errorBody, code))
                        )
                    } else {
                        callback.onResponse(
                            this@NetworkResourceCall,
                            Response.success(NetworkResource.NetworkError(null))
                        )
                    }
                }
            }

            override fun onFailure(call: Call<V>, t: Throwable) {
                val networkResponse = when(t) {
                    is IOException -> NetworkResource.NetworkError(t)
                    else -> NetworkResource.NetworkUnknowError(t)
                }

                callback.onResponse(
                    this@NetworkResourceCall,
                    Response.success(networkResponse)
                )
            }

        })
    }

    override fun isExecuted() = proxy.isExecuted

    override fun cancel() = proxy.cancel()

    override fun isCanceled() = proxy.isCanceled

    override fun clone() = NetworkResourceCall(proxy.clone(), errorConverter)

    override fun request(): Request = proxy.request()

    override fun timeout(): Timeout = proxy.timeout()

}