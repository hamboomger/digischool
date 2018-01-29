package com.digischool.model

/**
 * @author ddorochov
 */
class StudentSubjectStatus (
        val subject: Subject,
        val completedTopicsWithGrades: Map<String, Int> // <topic name, grade>
) {
    val completed : Boolean
        get() {
            val completedTopics = completedTopicsWithGrades.keys
            val subjectTopics = subject.topics.map { it.title }

            return subjectTopics.size == completedTopics.size
                    && completedTopics.containsAll(subjectTopics)
        }
}