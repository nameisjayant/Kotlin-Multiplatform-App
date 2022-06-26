package com.example.multiplatformapp.api_calling.di.repository

import com.example.multiplatformapp.api_calling.di.remote.ApiService
import kotlinx.coroutines.flow.flow

class PostRepository constructor(private val apiService: ApiService) {

    fun getPost() = flow {
        emit(apiService.fetchPost())
    }

    fun fetchPeople() = flow {
        emit(apiService.fetchPeople())
    }

    fun getLaunches() = flow {
        emit(apiService.getAllLaunches())
    }

    fun getPhone() = flow {
        emit(apiService.getPhone())
    }
}