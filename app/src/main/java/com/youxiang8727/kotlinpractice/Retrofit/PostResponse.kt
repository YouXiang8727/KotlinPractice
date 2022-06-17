package com.youxiang8727.kotlinpractice.Retrofit

data class PostResponse(
    val data: PostRequest,
    val json: PostRequest,
    val headers: Map<String, String>,
    val url: String,
) {
}