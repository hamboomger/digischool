package com.digischool.subject

import com.digischool.entity.Subject

/**
 * @author ddorochov
 */
interface SubjectsManager {
    fun getAllSubjects() : List<Subject>
    fun addSubject(subject: Subject)
}