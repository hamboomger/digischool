package com.digischool.model

import javax.persistence.*

/**
 * @author ddorochov
 */
@MappedSuperclass
open class User(
        val name: String,
        val surname: String,
        val email: String,
        val login: String,
        val password: String
)