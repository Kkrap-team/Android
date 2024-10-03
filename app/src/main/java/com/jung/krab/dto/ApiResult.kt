package com.jung.krab.dto

sealed class ApiResult <out T> {
    data object Loading : ApiResult<Nothing>()

    data class Success<out T>(val data: T) : ApiResult<T>()

    data class Error(val code: Int, val message: String?) : ApiResult<Nothing>()

    data class Exception(val e: Throwable) : ApiResult<Nothing>()
}