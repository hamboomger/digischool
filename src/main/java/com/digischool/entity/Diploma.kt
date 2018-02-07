package com.digischool.entity

import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class Diploma(
        @Id
        @GeneratedValue
        val id: Int,

        @OneToMany(targetEntity = SubjectResult::class)
        val minimalSubjectsResult: List<SubjectResult>
)