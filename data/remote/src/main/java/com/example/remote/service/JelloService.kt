package com.example.remote.service

import com.example.remote.model.base.ErrorResponse
import com.example.remote.model.base.NetworkResource
import com.example.remote.model.home.JelloHomeResponse
import com.example.remote.model.signin.JelloBaseResponse
import com.example.remote.model.signin.JelloSignInResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface JelloService {

    @FormUrlEncoded
    @POST("signin.php")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): NetworkResource<JelloBaseResponse<JelloSignInResponse>, ErrorResponse>

    @GET("home.php")
    suspend fun getHome(
        @Header("Authorization") token: String
    ): NetworkResource<JelloBaseResponse<JelloHomeResponse>, ErrorResponse>

}