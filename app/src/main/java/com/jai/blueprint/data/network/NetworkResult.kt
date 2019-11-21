package com.jai.blueprint.data.network

/**
 * Created by JAI on 14,November,2019
 * JAI KHAMBHAYTA
 */
sealed class NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>()
    data class Error(val error: Exception) : NetworkResult<Nothing>()
//    data class NoConnection(val exception: NoConnectivityException) : NetworkResult<Nothing>()
}