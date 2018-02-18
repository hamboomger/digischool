package com.digischool.user

import com.digischool.util.random
import org.springframework.stereotype.Service

/**
 * @author ddorochov
 */
@Service
class UsersManagerImpl(
        private val studentRepository: StudentRepository,
        private val teacherRepository: TeacherRepository
) : UsersManager {

    override fun registerStudent(student: Student) {
        studentRepository.save(student)
    }

    override fun registerTeacher(teacher: Teacher) {
        teacherRepository.save(teacher)
    }

    override fun updateStudent(student: Student) {
        studentRepository.save(student)
    }

    override fun generateStudentIndex(): Int {
        while (true) {
            val index = (10000..99999).random()

            if(studentRepository.findByStudentIndex(index) == null)
                return index
        }
    }

    override fun getTeacherByLoginAndPassword(login: String, password: String): Teacher? {
        return teacherRepository.findByLoginAndPassword(login, password)
    }

    override fun getStudentByLoginAndPassword(login: String, password: String): Student? {
        return studentRepository.findByLoginAndPassword(login, password)
    }

    override fun containsStudentWithEmail(email: String): Boolean {
        return studentRepository.findByEmail(email) != null
    }

    override fun containsStudentWithLogin(login: String): Boolean {
        return studentRepository.findByLogin(login) != null
    }

}