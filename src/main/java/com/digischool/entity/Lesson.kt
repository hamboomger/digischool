package com.digischool.entity

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