package com.digischool.user

import com.digischool.entity.Diploma
import com.digischool.entity.InterestGroup
import com.digischool.entity.StudyProgress
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

        var studentIndex: Int,

        @ManyToMany(targetEntity = InterestGroup::class)
        var interestGroups: List<InterestGroup> = mutableListOf(),

        @ManyToMany(targetEntity = Diploma::class)
        var diplomas: List<Diploma> = mutableListOf(),

        @Embedded
        var studyProgress: StudyProgress = StudyProgress()
) : User(id, name, surname, email, login, password) {
    constructor() : this(-1, "", "", "", "", "", -1)
}