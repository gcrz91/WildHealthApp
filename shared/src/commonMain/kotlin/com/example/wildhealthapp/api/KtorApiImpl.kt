package com.example.wildhealthapp.api

import com.example.wildhealthapp.BuildKonfig
import com.example.wildhealthapp.utils.Constants
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorApiImpl: KtorApi {

    override val client = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        install(HttpTimeout) {
            val timeout = 30000L
            connectTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }
        defaultRequest {
            headers {
                append(Constants.API_HOST_HEADER, Constants.API_HOST)
                append(Constants.API_KEY_HEADER, BuildKonfig.apiKey)
            }
        }
    }

    override fun HttpRequestBuilder.apiUrl(path: String) {
        url {
            takeFrom(Constants.BASE_URL)
            encodedPath = path
        }
    }

    override fun HttpRequestBuilder.json() {
        contentType(ContentType.Application.Json)
    }
}