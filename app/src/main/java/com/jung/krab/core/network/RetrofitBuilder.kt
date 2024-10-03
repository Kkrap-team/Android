package com.jung.krab.core.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder() {
    companion object {
        private const val CONNECT_TIMEOUT = 10000L
        private const val WRITE_TIMEOUT = 10000L
        private const val READ_TIMEOUT = 10000L
        private const val URL = "http://43.203.234.0:8080"
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
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClientBuilder.addInterceptor(logging)
//        }

//        val okHttpClient = httpClientBuilder.build()
        val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(logging)
                .build()

        val baseUrl = URL
        var gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
//            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }
}