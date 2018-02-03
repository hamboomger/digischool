package com.digischool.model

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * @author ddorochov
 */
@Entity
class Question(
        @Id
        @GeneratedValue
        val id: Int,

        val content: String,

        @ElementCollection
        val answers: List<String>,

        val rightAnswer: String
)