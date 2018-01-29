package com.digischool.model

/**
 * @author ddorochov
 */

class Teacher(
        name: String,
        surname: String,
        email: String,
        login: String,
        password: String,
        val inChargeForSubjects: List<Subject>
) : User(name, surname, email, login, password)