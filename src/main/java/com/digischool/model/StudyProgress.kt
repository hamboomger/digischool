package com.digischool.model

import javax.persistence.CascadeType
import javax.persistence.Embeddable
import javax.persistence.OneToMany

/**
 * @author ddorochov
 */
@Embeddable
class StudyProgress(
        @OneToMany(
                targetEntity = StudentSubjectStatus::class,
                cascade = arrayOf(CascadeType.ALL)
        )
        val subjectsStatuses: List<StudentSubjectStatus> = mutableListOf()
) {

    val completedSubjects : List<Subject>
        get() = subjectsStatuses
                    .filter { it.completed }
                    .map { it.subject }

}