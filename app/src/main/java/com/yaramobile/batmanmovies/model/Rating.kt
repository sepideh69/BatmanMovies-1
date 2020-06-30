package com.yaramobile.batmanmovies.model

import com.google.gson.annotations.SerializedName

class Rating(
    @SerializedName("Source")
    val source: String,
    @SerializedName("Value")
    val value: String
)