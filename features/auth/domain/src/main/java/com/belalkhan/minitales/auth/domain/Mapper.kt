package com.belalkhan.minitales.auth.domain

interface Mapper<F,T> {
    fun map(from:F):T
}