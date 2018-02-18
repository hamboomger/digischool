package com.digischool.subject

import com.digischool.entity.Subject
import com.digischool.user.Student
import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class StudentSubjectStatus (
        @Id
        @GeneratedValue
        val id: Int,

        @ManyToOne
        val student: Student,

        @ManyToOne
        val subject: Subject,

        @ElementCollection
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