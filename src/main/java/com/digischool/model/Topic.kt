package com.digischool.model

/**
 * @author ddorochov
 */
class Topic(
        val title: String,
        val lessons: List<Lesson>,
        val tests: List<Test>
)