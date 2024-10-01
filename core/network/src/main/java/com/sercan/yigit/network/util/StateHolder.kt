package com.sercan.yigit.network.util

data class StateHolder<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String = ""
)