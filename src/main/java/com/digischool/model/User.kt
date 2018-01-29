package com.digischool.model

/**
 * @author ddorochov
 */
open class User(
        val name: String,
        val surname: String,
        val email: String,
        val login: String,
        val password: String
)