package com.ordiotz.mapping.domain.model.response

object ResponseCode {
    const val SUCCESS = 200_0000
    const val BAD_REQUEST = 400_0000
    const val ACCESS_INVALID = 401_0001
    const val ACCESS_EXPIRED = 401_0002
    const val REFRESH_INVALID = 401_0003
    const val REFRESH_EXPIRED = 401_0004
    const val UNAUTHORIZED = 401_0005
    const val INTERNET_SERVER_ERROR = 500_0000
    const val NOT_FOUND = 404_0000
    const val METHOD_NOT_ALLOWED = 405_0000
    const val UNKNOWN = 100_0000
}