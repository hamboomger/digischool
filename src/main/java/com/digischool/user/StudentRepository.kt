package com.digischool.user

import com.digischool.user.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * @author ddorochov
 */
@Repository
interface StudentRepository: CrudRepository<Student, Int> {
    fun findByLoginAndPassword(login: String, password: String): Student?
    fun findByStudentIndex(index: Int): Student?
}