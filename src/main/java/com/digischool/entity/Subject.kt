package com.digischool.entity

import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class Subject(
        @Id
        @GeneratedValue
        val id: Int? = null,
        val name: String,

        @OneToMany(targetEntity = Topic::class, cascade = arrayOf(CascadeType.ALL))
        val topics: List<Topic> = mutableListOf()
)