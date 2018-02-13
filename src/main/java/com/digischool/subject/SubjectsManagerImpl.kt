package com.digischool.subject

import com.digischool.entity.Subject
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author ddorochov
 */
@Service
class SubjectsManagerImpl(val subjectsRepository: SubjectsRepository) : SubjectsManager {

    override fun getAllSubjects(): List<Subject> {
        return subjectsRepository.findAll().toList()
    }

    override fun addSubject(subject: Subject) {
        subjectsRepository.save(subject)
    }

}