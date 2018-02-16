package com.digischool.user

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * @author ddorochov
 */
@Repository
interface TeacherRepository : CrudRepository<Teacher, Long> {
    fun findByLoginAndPassword(login: String, password: String): Teacher
}