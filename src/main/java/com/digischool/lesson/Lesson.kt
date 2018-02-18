package com.digischool.lesson

import com.digischool.entity.Subject
import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class Lesson(
        @Id
        @GeneratedValue
        val id: Int,

        @ManyToOne
        val subject: Subject,

        val title: String,
        val content: String
)