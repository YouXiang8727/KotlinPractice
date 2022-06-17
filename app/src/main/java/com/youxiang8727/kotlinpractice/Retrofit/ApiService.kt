package com.youxiang8727.kotlinpractice.Retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    companion object {
        const val URL = "https://postman-echo.com"
    }
    @POST("/post")
    suspend fun post(@Body request: PostRequest): Response<PostResponse>
}