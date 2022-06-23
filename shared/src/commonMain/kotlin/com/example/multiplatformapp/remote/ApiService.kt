package com.example.multiplatformapp.remote

import com.example.multiplatformapp.model.Post
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiService(
    private val client:HttpClient,
    val baseUrl:String = "https://www.jsonplaceholder.typicode.com"
){

    suspend fun fetchPost():List<Post>{
        return client.get {
            url("$baseUrl/posts")
        }.body()
    }

}