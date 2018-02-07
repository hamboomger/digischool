package com.digischool.registration

import com.digischool.repository.StudentRepository
import com.digischool.util.random
import org.springframework.stereotype.Service

/**
 * @author ddorochov
 */
@Service
class RegistrationService(val studentRepository: StudentRepository) {

    fun generateStudentIndex() : Int {
        while (true) {
            val index = (10000..99999).random()

            if(studentRepository.findByStudentIndex(index) == null)
                return index
        }
    }

}