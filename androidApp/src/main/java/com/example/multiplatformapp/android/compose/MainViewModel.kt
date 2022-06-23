package com.example.multiplatformapp.android.compose

import androidx.lifecycle.ViewModel
import com.example.multiplatformapp.repository.PostRepository

class MainViewModel constructor(private val repository: PostRepository) : ViewModel() {
}