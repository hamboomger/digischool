package com.digischool.model

import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

/**
 * @author ddorochov
 */
@Entity
open class Student(
        name: String,
        surname: String,
        email: String,
        login: String,
        password: String,
        val index: Int,
        val interestGroups: List<InterestGroup> = mutableListOf(),
        val diplomas: List<Diploma> = mutableListOf(),
        val studyProgress: StudyProgress = StudyProgress(),
        val teachersOpinion: Map<String, Int> = mutableMapOf() // teacher's login, grade from 2 to 5
) : User(name, surname, email, login, password)