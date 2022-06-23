package com.example.multiplatformapp.repository

import com.example.multiplatformapp.model.Post
import com.example.multiplatformapp.remote.ApiService
import kotlinx.coroutines.flow.flow

class PostRepository constructor(private val apiService: ApiService) {

    fun getPost() = flow<List<Post>> {
        apiService.fetchPost()
    }

}