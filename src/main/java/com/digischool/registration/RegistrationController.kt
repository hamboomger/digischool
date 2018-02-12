package com.digischool.registration

import com.digischool.user.Student
import com.digischool.user.UsersManager
import tornadofx.Controller

/**
 * @author ddorochov
 */
class RegistrationController : Controller() {
    val usersManager: UsersManager by di()

    fun registerStudent(student: Student) = usersManager.registerStudent(student)
}