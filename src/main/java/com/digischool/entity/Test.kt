package com.digischool.entity

import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class Test(
        @Id
        @GeneratedValue
        val id: Int,

        @OneToMany(targetEntity = Question::class, cascade = arrayOf(CascadeType.REMOVE))
        val questions: List<Question>
)