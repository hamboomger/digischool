package com.digischool.repository

import com.digischool.model.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * @author ddorochov
 */
@Repository
interface StudentRepository: CrudRepository<Student, Int> {
    fun findByLoginAndPassword(login: String, password: String): Student?
}