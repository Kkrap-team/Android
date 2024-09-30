package com.jung.krab.core.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder() {
    companion object{
        private const val CONNECT_TIMEOUT = 100L
        private const val WRITE_TIMEOUT = 100L
        private const val READ_TIMEOUT = 100L
        private const val URL = ""
    }

    fun getRetrofit(): Retrofit {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.addInterceptor(Interceptor { chain ->
            chain.proceed(chain.request().newBuilder().build())
        })
        httpClientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)

//        TODO API 통신 debug 여부결정
//        if (Config.DEBUG) {
//            val logging = HttpLoggingInterceptor()
//            logging.level = HttpLoggingInterceptor.Level.BODY
//            httpClientBuilder.addInterceptor(logging)
//        }

        val okHttpClient = httpClientBuilder.build()
        val baseUrl = URL

        return Retrofit.Builder()
            .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
    }
}