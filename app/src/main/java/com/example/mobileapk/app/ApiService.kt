package com.example.mobileapk.app


import com.example.mobileapk.model.ResponModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {


    @FormUrlEncoded
    @POST("register")
    fun  register(
        @Field("name") name : String,
        @Field("email") email : String,
        @Field("phone") nomortlp : String,
        @Field("password") password : String

    ): Call<ResponModel>

    @FormUrlEncoded
    @POST("login")
    fun  login(
        @Field("email") email : String,
        @Field("password") password : String

    ): Call<ResponModel>
}