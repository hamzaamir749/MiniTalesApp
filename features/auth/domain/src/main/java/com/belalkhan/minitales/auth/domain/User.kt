package com.belalkhan.minitales.auth.domain

data class User(
    val authToken: String? = null,
    val avatar: String,
    val createdAt: String,
    val email: String,
    val fullName: String,
    val id: Int
)
