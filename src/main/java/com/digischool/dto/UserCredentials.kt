package com.digischool.dto

import tornadofx.getProperty
import tornadofx.property

/**
 * @author ddorochov
 */
class UserCredentials(username: String, password: String) {
    var login by property(username)
    var password by property(password)

    constructor() : this("", "")

    fun loginProperty() = getProperty(UserCredentials::login)
    fun passwordProperty() = getProperty(UserCredentials::password)
}
