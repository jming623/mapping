package com.ordiotz.mapping.app.util

import com.ordiotz.mapping.domain.exception.AppException
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<out T>(
    val code: Int,
    val message: String,
    val count: Int? = null,
    val data: T? = null
) {
    companion object {
        fun <T> success(data: T): BaseResponse<T> {
            println("BaseResponse의 success 호출")
            val count = if (data is List<*>) {
                data.size
            } else if(data != null){
                1
            }else {
                null
            }
            println("count > ${count}")

            return BaseResponse(code=200, message="SUCCESS", count=count, data= data)
        }
        fun error(exception: AppException): BaseResponse<Boolean?> {
            return BaseResponse(code =exception.code, message = exception.message!!)
        }
    }
}