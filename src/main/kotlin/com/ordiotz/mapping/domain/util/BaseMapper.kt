package com.ordiotz.mapping.domain.util

interface BaseMapper<Domain, Data> {
    fun Domain.toData(): Data
    fun Data.toDomain(): Domain
}