package com.example.multiplatformapp.android.compose.di


import com.example.multiplatformapp.android.compose.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel{MainViewModel(get())}
}