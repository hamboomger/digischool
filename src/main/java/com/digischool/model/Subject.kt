package com.digischool.model

import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class Subject(
        @Id
        @GeneratedValue
        val id: Int,
        val name: String,

        @OneToMany(targetEntity = Topic::class, cascade = arrayOf(CascadeType.ALL))
        val topics: List<Topic>
)