package com.jai.blueprint.ui.base

import com.jai.blueprint.data.network.NetworkResult
import com.jai.blueprint.data.network.NoConnectivityException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException

/**
 * Created by JAI on 14,November,2019
 * JAI KHAMBHAYTA
 */
open class BaseRepository {
    suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>,
        errorContext: String
    ): NetworkResult<T>? {
        val result: NetworkResult<T> = safeApiResult(call)
        return result

    }

    private suspend fun <T : Any> safeApiResult(call: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = call.invoke()
            if (response.isSuccessful) return NetworkResult.Success(response.body()!!)
            return NetworkResult.Error(IOException(setErrorMessage(response)))
        } catch (exception: IOException) {
            if (exception is NoConnectivityException) return NetworkResult.Error(exception)
            return NetworkResult.Error(exception)
        }

    }

    private fun <T : Any> setErrorMessage(response: Response<T>): String {
        val code = response.code().toString()
        val message = try {
            val jObjError = JSONObject(response.errorBody()?.string())
            jObjError.getJSONObject("error").getString("message")
        } catch (e: Exception) {
            e.message
        }
//        return if (message.isNullOrEmpty()) " error code = $code " else " error code = $code  & error message = $message "
        return if (message.isNullOrEmpty()) " error code = $code " else "$message "
    }


}