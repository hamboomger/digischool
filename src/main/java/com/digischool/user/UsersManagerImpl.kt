package com.digischool.user

import com.digischool.util.random

/**
 * @author ddorochov
 */
class UsersManagerImpl(
        private val studentRepository: StudentRepository,
        private val teacherRepository: TeacherRepository
) : UsersManager {

    override fun registerStudent(student: Student) {
        studentRepository.save(student)
    }

    override fun generateStudentIndex(): Int {
        while (true) {
            val index = (10000..99999).random()

            if(studentRepository.findByStudentIndex(index) == null)
                return index
        }
    }

    override fun registerTeacher(teacher: Teacher) {
        teacherRepository.save(teacher)
    }

}