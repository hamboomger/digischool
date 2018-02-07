package com.digischool.login

import com.digischool.repository.StudentRepository
import org.springframework.stereotype.Controller

/**
 * @author ddorochov
 */
@Controller
class AuthorizationController(val studentRepository: StudentRepository) {

    /**
     * @return userId, null if user not exists
     */
    fun authorise(login: String, password: String, isTeacher: Boolean) : Int? {
        if(!isTeacher) {
            val student = studentRepository.findByLoginAndPassword(login, password)
            return student?.id
        } else {
            return null
        }
    }

}