package com.example.multiplatformapp.api_calling.di

import com.example.multiplatformapp.api_calling.di.remote.ApiService
import com.example.multiplatformapp.api_calling.di.repository.PostRepository
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule())
}

fun initKoin() = initKoin { }

fun commonModule() = module {
    single { createJson() }
    single { createHttpClient(get()) }
    single { ApiService(get()) }
    factory { PostRepository(get()) }
}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(json: Json) = HttpClient {

    install(ContentNegotiation) {
        json(json)
    }

    install(DefaultRequest) {
        headers.append("Content-Type", "application/json")
    }


    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
}