package com.example.multiplatformapp.android.compose

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multiplatformapp.model.Post
import com.example.multiplatformapp.repository.PostRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: PostRepository) : ViewModel() {

    private val _response:MutableState<List<Post>> = mutableStateOf(listOf())
    val response = _response

    init {
        getPost()
        viewModelScope.launch {
            repository.getPhone()
                .onStart {
                    Log.d("main", "Loading....")
                }
                .catch {e->
                    Log.d("main", "getPeople: ${e.message}")
                }.collect{
                    Log.d("main", "getPeople: ${it[0].name}")
                }
        }
    }



    private fun getPost() = viewModelScope.launch {
        repository.getPost()
            .catch {e->
                Log.d("main", "getPost: ${e.message}")
            }.collect{
                _response.value = it
            }
    }

     fun getPeople() = viewModelScope.launch {
        repository.fetchPeople()
            .onStart {  }
            .catch {e->
                Log.d("main", "getPeople: ${e.message}")
            }.collect{
                Log.d("main", "getPeople: ${it.message}")
            }
    }




}