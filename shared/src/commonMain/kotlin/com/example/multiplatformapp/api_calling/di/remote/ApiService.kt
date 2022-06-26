package com.example.multiplatformapp.api_calling.di.remote

import com.example.multiplatformapp.api_calling.di.model.AstroResult
import com.example.multiplatformapp.api_calling.di.model.Phone
import com.example.multiplatformapp.api_calling.di.model.Post
import com.example.multiplatformapp.api_calling.di.model.RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiService(
    private val client: HttpClient,
    val baseUrl: String = "https://jsonplaceholder.typicode.com/",
    val url: String = "https://people-in-space-proxy.ew.r.appspot.com/",
    val phoneUrl:String = "https://phone-api-8826.herokuapp.com/v1"
) {

    suspend fun fetchPost(): List<Post> {
        return client.get {
            url("$baseUrl/posts")
        }.body()
    }

    suspend fun fetchPeople() = client.get("$url/astros.json").body<AstroResult>()

    suspend fun getPhone():List<Phone> = client.get("$phoneUrl/phone").body<List<Phone>>()


    suspend fun getAllLaunches(): List<RocketLaunch> {
        return client.get(LAUNCHES_ENDPOINT).body()
    }

    companion object {
        private const val LAUNCHES_ENDPOINT = "https://api.spacexdata.com/v3/launches"
    }

}