package com.digischool.model

import javax.persistence.Entity
import javax.persistence.ManyToMany

/**
 * @author ddorochov
 */
@Entity
class Teacher(
        id: Int,
        name: String,
        surname: String,
        email: String,
        login: String,
        password: String,

        @ManyToMany
        val inChargeForSubjects: List<Subject>
) : User(id, name, surname, email, login, password)