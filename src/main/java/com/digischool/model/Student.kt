package com.digischool.model

import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
open class Student(
        id: Int,
        name: String,
        surname: String,
        email: String,
        login: String,
        password: String,

        @Column(name = "studentIndex")
        var index: Int,

        @ManyToMany(targetEntity = InterestGroup::class)
        var interestGroups: List<InterestGroup> = mutableListOf(),

        @ManyToMany(targetEntity = Diploma::class)
        var diplomas: List<Diploma> = mutableListOf(),

        @Embedded
        var studyProgress: StudyProgress = StudyProgress()
) : User(id, name, surname, email, login, password)