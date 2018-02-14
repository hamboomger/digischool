package com.digischool.user

import org.springframework.stereotype.Service

/**
 * @author ddorochov
 */
@Service
interface UsersManager {
    fun registerStudent(student: Student)

    fun registerTeacher(teacher: Teacher)

    fun getTeacherByLoginAndPassword(login: String, password: String) : Teacher?

    fun getStudentByLoginAndPassword(login: String, password: String) : Student?

    fun generateStudentIndex(): Int
}