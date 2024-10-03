package com.jung.krab.core.network

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.jung.krab.dto.ApiResult
import com.jung.krab.utils.LogUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class Repository(retrofit: RetrofitBuilder) {
    val api: RetrofitService = retrofit.getRetrofit().create(RetrofitService::class.java)

    private fun <T> handleFlowApi(
        execute: suspend () -> T,
    ): Flow<ApiResult<T>> = flow {
        emit(ApiResult.Loading)
        delay(1000)
        try {
            emit(ApiResult.Success(execute()))
        } catch (e: HttpException) {
            emit(ApiResult.Error(code = e.code(), message = e.message()))
        } catch (e: Exception) {
            emit(ApiResult.Exception(e = e))
        }
    }

    fun <T> getToJsons(
        url: String,
        body: MutableMap<String, Any>,
        classOfT: Class<T>
    ): Flow<ApiResult<T>> = handleFlowApi {
        val res = api.getToJson(url, body).asJsonObject
        LogUtils.error("++getToJsons() = $res")
        Gson().fromJson(res, classOfT)
    }

    fun <T> getToJsons(
        url: String,
        headerMap: MutableMap<String, Any>,
        body: MutableMap<String, Any>,
        classOfT: Class<T>
    ): Flow<ApiResult<T>>  = handleFlowApi {
        val res = api.getToJson(url, headerMap, body).asJsonObject
        LogUtils.error("++getToJsons() = $res")
        Gson().fromJson(res, classOfT)
    }

    fun <T> postToJsons(
        url: String,
        headers: MutableMap<String, Any>,
        body: MutableMap<String, Any>,
        classOfT: Class<T>
    ): Flow<ApiResult<T>>  = handleFlowApi {
        val res = api.postToJson(url,headers, body).asJsonObject
        LogUtils.error("++postToJsons() = $res")
        Gson().fromJson(res, classOfT)
    }

    fun <T> postToJsons(
        url: String,
        body: MutableMap<String, Any>,
        classOfT: Class<T>
    ): Flow<ApiResult<T>> = handleFlowApi {
        val res = api.postToJson(url, body).asJsonObject
        LogUtils.error("++postToJsons() = $res")
        Gson().fromJson(res, classOfT)
    }

    fun <T> putToJsons(
        url: String,
        headers: MutableMap<String, Any>,
        body: MutableMap<String, Any>,
        classOfT: Class<T>
    ): Flow<ApiResult<T>> = handleFlowApi {
        val res = api.putToJson(url,headers, body).asJsonObject
        LogUtils.error("++putToJsons() = $res")
        Gson().fromJson(res, classOfT)
    }

    fun <T> patchToJsons(
        url: String,
        headers: MutableMap<String, Any>,
        body: MutableMap<String, Any>,
        classOfT: Class<T>
    ): Flow<ApiResult<T>> = handleFlowApi {
        val res = api.patchToJson(url,headers, body).asJsonObject
        LogUtils.error("++patchToJsons() = $res")
        Gson().fromJson(res, classOfT)
    }

    fun <T> deleteToJsons(
        url: String,
        headers: MutableMap<String, Any>,
        body: MutableMap<String, Any>,
        classOfT: Class<T>
    ): Flow<ApiResult<T>>  = handleFlowApi {
        val res = api.deleteToJson(url,headers, body).asJsonObject
        LogUtils.error("++deleteToJsons() = $res")
        Gson().fromJson(res, classOfT)
    }
}