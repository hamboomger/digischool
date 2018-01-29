package com.digischool.model

/**
 * @author ddorochov
 */
class Question(
        val content: String,
        val answers: List<String>,
        val rightAnswer: String
)