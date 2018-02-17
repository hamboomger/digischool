package com.digischool.user

import com.digischool.entity.*
import com.digischool.interest_group.InterestGroup
import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class Student(
        id: Int? = null,
        name: String,
        surname: String,
        email: String,
        login: String,
        password: String,

        open var studentIndex: Int,

        @ManyToMany(targetEntity = InterestGroup::class, fetch = FetchType.EAGER)
        open var interestGroups: MutableSet<InterestGroup> = mutableSetOf(),

        @ManyToMany(targetEntity = Diploma::class, fetch = FetchType.EAGER)
        open var diplomas: MutableSet<Diploma> = mutableSetOf(),

        @OneToMany(targetEntity = StudentSubjectStatus::class, fetch = FetchType.EAGER)
        open var subjectsStatuses: MutableSet<StudentSubjectStatus> = mutableSetOf()

) : User(id, name, surname, email, login, password) {

    constructor() : this(-1, "", "", "", "", "", -1)

    val completedSubjects : List<Subject>
        get() = subjectsStatuses
                .filter { it.completed }
                .map { it.subject }

}