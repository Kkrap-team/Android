package com.jung.krab.dto

sealed class Result <out T> (val data: T?, val message:String?) {
    data class Success<out R>(val _data: R?): Result<R>(
        data = _data,
        message = null
    )

    data class Error(val exception: String): Result<Nothing>(
        data = null,
        message = exception
    )

    data class Loading<out R>(val _data: R?, val isLoading: Boolean): Result<R>(
        data = _data,
        message = null
    )
}