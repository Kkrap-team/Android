package com.jung.krab.core.network

import com.google.gson.JsonElement
import com.jung.krab.dto.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface RetrofitService {
    @GET
    suspend fun getToJson(
        @Url url:String,
        @QueryMap body: MutableMap<String, Any>
    ): Result<JsonElement>

    @GET
    suspend fun getToJson(
        @Url url:String,
        @HeaderMap headerMap: MutableMap<String, Any>,
        @QueryMap body: MutableMap<String, Any>
    ): Result<JsonElement>
    
    @Headers("Content-Type: application/json")
    @POST
    suspend fun postToJson(
        @Url url: String,
        @HeaderMap headers: MutableMap<String,Any>,
        @Body body: MutableMap<String,Any>
    ): Result<JsonElement>

    @Headers("Content-Type: application/json")
    @POST
    suspend fun postToJson(
        @Url url: String,
        @Body body: MutableMap<String,Any>
    ): Result<JsonElement>

    @Headers("Content-Type: application/json")
    @PUT
    suspend fun putToJson(
        @Url url: String,
        @HeaderMap headers: MutableMap<String,Any>,
        @Body body: MutableMap<String,Any>
    ): Result<JsonElement>


    @Headers("Content-Type: application/json")
    @PATCH
    suspend fun patchToJson(
        @Url url: String,
        @HeaderMap headers: MutableMap<String,Any>,
        @Body body: MutableMap<String,Any>
    ): Result<JsonElement>

    @Headers("Content-Type: application/json")
    @DELETE
    suspend fun deleteToJson(
        @Url url: String,
        @HeaderMap headers: MutableMap<String,Any>,
        @QueryMap body: MutableMap<String,Any>
    ): Result<JsonElement>

}
