package com.digischool.model

/**
 * @author ddorochov
 */
class StudyProgress(
    val subjectsStatuses: List<StudentSubjectStatus> = mutableListOf()
) {
    val completedSubjects : List<Subject>
        get() {
            return subjectsStatuses
                    .filter { it.completed }
                    .map { it.subject }
        }
}