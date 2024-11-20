package com.ordiotz.mapping.domain.exception

import com.ordiotz.mapping.domain.model.response.ResponseCode

sealed class AppException(val code: Int): Exception() {
    data class UnknownException(override val message: String = "알 수 없는 에러가 발생했습니다."): AppException(code=ResponseCode.UNKNOWN)
    data class DataNotFoundException(override val message: String = "데이터를 찾을 수 없습니다."): AppException(code=ResponseCode.NOT_FOUND)
}