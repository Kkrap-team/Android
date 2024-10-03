package com.jung.krab.dto

import com.google.gson.annotations.SerializedName

data class Test(
    @SerializedName("id")
    val id: String,
    @SerializedName("joke")
    val joke: String,
    @SerializedName("status")
    val status: Int
)