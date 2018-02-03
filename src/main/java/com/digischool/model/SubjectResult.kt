package com.digischool.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * @author ddorochov
 */
@Entity
class SubjectResult(
       @Id
       @GeneratedValue
       val id: Int,

       @ManyToOne
       val subject: Subject,

       val result: Int
)