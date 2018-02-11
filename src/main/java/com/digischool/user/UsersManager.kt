package com.digischool.user

import org.springframework.stereotype.Service

/**
 * @author ddorochov
 */
@Service
interface UsersManager {
    fun registerStudent(student: Student)

    fun generateStudentIndex(): Int

    fun registerTeacher(teacher: Teacher)
}