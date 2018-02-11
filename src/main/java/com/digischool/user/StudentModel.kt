package com.digischool.user

import tornadofx.ItemViewModel
import tornadofx.observable

/**
 * @author ddorochov
 */
class StudentModel : ItemViewModel<Student>() {
    val name = bind { item?.observable(Student::name) }
    val surname = bind { item?.observable(Student::surname) }
    val email = bind { item?.observable(Student::email) }
    val login = bind { item?.observable(Student::login) }
    val password = bind { item?.observable(Student::password) }
    val index = bind { item?.observable(Student::index) }
    val interestGroups = bind { item?.observable(Student::interestGroups) }
    val diplomas = bind { item?.observable(Student::diplomas) }
    val studyProgress = bind { item?.observable(Student::interestGroups) }
}