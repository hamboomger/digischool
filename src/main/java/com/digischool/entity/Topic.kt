package com.digischool.entity

import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class Topic(
        @Id
        @GeneratedValue
        val id: Int,

        @ManyToOne
        val subject: Subject,

        val title: String,

        @OneToMany(targetEntity = Lesson::class)
        val lessons: List<Lesson>,

        @OneToMany(targetEntity = Test::class)
        val tests: List<Test>
)