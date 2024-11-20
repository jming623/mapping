package com.ordiotz.mapping.app.routing

import com.ordiotz.mapping.app.ext.errorFilter
import com.ordiotz.mapping.app.util.BaseResponse
import com.ordiotz.mapping.domain.exception.AppException
import com.ordiotz.mapping.domain.service.UserService
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.*

fun Route.addUserRoute(
    userService: UserService
) {
    route("all-users"){
        get {
            try {
                userService.getAllUsers().errorFilter(call) { data ->
                    call.respond(BaseResponse.success(data))
                }
            } catch (e: AppException){
                call.respond(BaseResponse.error(e))
            }
        }
    }
}


private fun RoutingCall.respond() {
    TODO("Not yet implemented")
}


