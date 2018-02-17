package com.digischool.login

import com.digischool.user.Student
import com.digischool.user.StudentModel
import com.digischool.user.Teacher
import com.digischool.user.UsersManager
import org.springframework.stereotype.Controller

/**
 * @author ddorochov
 */
@Controller
class AuthorizationController(val usersManager: UsersManager) {

    /**
     * @return student, null if user not exists
     */
    fun authoriseStudent(login: String, password: String) : Student? {
        return usersManager.getStudentByLoginAndPassword(login, password)
    }

    /**
     * @return teacher, null if user not exists
     */
    fun authoriseTeacher(login: String, password: String) : Teacher? {
        return usersManager.getTeacherByLoginAndPassword(login, password)
    }

    fun createNewStudentModel(student: Student) = StudentModel(student)

}