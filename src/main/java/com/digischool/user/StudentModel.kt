package com.digischool.user

import com.digischool.util.observableList
import com.digischool.util.observableSet
import tornadofx.*

/**
 * @author ddorochov
 */
class StudentModel() : ItemViewModel<Student>() {
    constructor(student: Student) : this() { this.item = student }

    val name = bind { item?.observable(Student::name) }
    val surname = bind { item?.observable(Student::surname) }
    val email = bind { item?.observable(Student::email) }
    val login = bind { item?.observable(Student::login) }
    val password = bind { item?.observable(Student::password) }
    val index = bind { item?.observable(Student::studentIndex) }
    val interestGroups = bind { observableSet(item?.interestGroups) }
    val diplomas = bind { observableSet(item?.interestGroups) }
    val subjectsStatuses = bind { observableSet(item?.subjectsStatuses) }
}