package com.ordiotz.mapping.app.ext

import com.ordiotz.mapping.app.util.BaseResponse
import com.ordiotz.mapping.domain.exception.AppException
import io.ktor.server.response.respond
import io.ktor.server.routing.RoutingCall

suspend fun<T> Result<T>.errorFilter(call: RoutingCall, onSuccess: suspend ((T) -> Unit)) {
    if (isSuccess){
        onSuccess.invoke(getOrNull()!!)
    }else{
        exceptionOrNull()?.let {
            if (it is AppException.DataNotFoundException){
                call.respond(BaseResponse.error(AppException.DataNotFoundException()))
            } else {
                call.respond(BaseResponse.error(AppException.UnknownException()))
            }
        } ?: run {
            call.respond(BaseResponse.error(AppException.UnknownException()))
        }
    }
}