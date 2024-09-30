package com.jung.krab.core.network

import com.google.gson.JsonElement
import com.jung.krab.dto.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository(private val retrofit: RetrofitBuilder) {
    val api: RetrofitService = retrofit.getRetrofit().create(RetrofitService::class.java)
    
    fun getToJsons(url: String, body: MutableMap<String, Any>): Flow<Result<JsonElement>> = flow {
        emit(api.getToJson(url, body))
    }

    fun getToJsons(
        url: String,
        headerMap: MutableMap<String, Any>,
        body: MutableMap<String, Any>
    ): Flow<Result<JsonElement>> = flow{
        emit(api.getToJson(url,headerMap,body))
    }

    fun postToJsons(
        url: String,
        headers: MutableMap<String, Any>,
        body: MutableMap<String, Any>
    ): Flow<Result<JsonElement>>  = flow{
        emit(api.postToJson(url,headers,body))
    }

    fun postToJsons(url: String, body: MutableMap<String, Any>): Flow<Result<JsonElement>> = flow{
        emit(api.postToJson(url, body))
    }

    fun putToJsons(
        url: String,
        headers: MutableMap<String, Any>,
        body: MutableMap<String, Any>
    ): Flow<Result<JsonElement>> = flow{
        emit(api.putToJson(url, headers, body))
    }

    fun patchToJsons(
        url: String,
        headers: MutableMap<String, Any>,
        body: MutableMap<String, Any>
    ): Flow<Result<JsonElement>> = flow{
        emit(api.patchToJson(url, headers, body))
    }

    fun deleteToJsons(
        url: String,
        headers: MutableMap<String, Any>,
        body: MutableMap<String, Any>
    ): Flow<Result<JsonElement>> = flow{
        emit(api.deleteToJson(url, headers, body))
    }
}