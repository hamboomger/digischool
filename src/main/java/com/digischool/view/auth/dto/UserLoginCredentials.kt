package com.digischool.view.auth.dto

import tornadofx.getProperty
import tornadofx.property

/**
 * @author ddorochov
 */
class UserLoginCredentials(login: String, password: String, isTeacher: Boolean) {
    var login by property(login)
    var password by property(password)
    var isTeacher by property(isTeacher)

    constructor() : this("", "", false)

    fun loginProperty() = getProperty(UserLoginCredentials::login)
    fun passwordProperty() = getProperty(UserLoginCredentials::password)
    fun isTeacherProperty() = getProperty(UserLoginCredentials::isTeacher)
}
