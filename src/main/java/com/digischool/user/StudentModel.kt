package com.digischool.user

import com.digischool.entity.InterestGroup
import javafx.collections.ObservableList
import tornadofx.ItemViewModel
import tornadofx.observable

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
//    val interestGroups = bind<ObservableList<InterestGroup>, InterestGroup, ObservableList<InterestGroup>> { item?.interestGroups?.observable() }
//    val diplomas = bind { item?.observable(Student::diplomas) }
//    val studyProgress = bind { item?.observable(Student::interestGroups) }
}