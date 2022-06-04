package com.hiroshisasmita.android_core.base

import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.lang.reflect.Type

abstract class BaseRetrofitResponsePlainAdapter<C: Any, V: Any> {

    /**
     * Function to handle asynchronous api
     */
    suspend fun handleApi(block: suspend () -> Response<C>): V? {
        return try {
            val response = block.invoke()
            proceed(response)
        }catch (e: Exception) {
            throw e
        }

    }

    /**
     * Function to handle synchronous api
     */
    fun handleApiSynchronously(block: () -> Call<C>): V? {
        return try {
            val response = block.invoke().execute()
            proceed(response)
        }catch (e: Exception) {
            throw e
        }

    }

    /**
     * Function to proceed api call
     */
    @Throws(Exception::class)
    private fun proceed(response: Response<C>): V? {
        if (!response.isSuccessful) {
            throw response.errorBody()?.let {
                fetchError(it, response.code())
            } ?: Exception()
        }

        return response.body()?.let {
            fetchSuccessData(it)
        }
    }

    /**
     * Function to handle data when response isSuccessful
     */
    @Throws(Exception::class)
    protected abstract fun fetchSuccessData(data: C): V?

    /**
     * Function to handle data when response isError
     */
    protected abstract fun fetchError(errorBody: ResponseBody, responseCode: Int): Exception

    protected fun <T> ResponseBody.errorBodyParser(type: Class<T>): T? {
        return this.string().let {
            Gson().fromJson(it, type)
        }
    }

    protected fun <T> ResponseBody.errorBodyParser(type: Type): T? {
        return this.string().let {
            Gson().fromJson(it, type)
        }
    }
}