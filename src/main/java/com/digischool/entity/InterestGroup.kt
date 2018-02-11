package com.digischool.entity

import com.digischool.user.Student
import com.digischool.user.Teacher
import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class InterestGroup(
        @Id
        @GeneratedValue
        val id: Int,

        @ManyToMany(targetEntity = Student::class)
        val students: List<Student>,

        @ManyToOne
        val subject: Subject,

        @ManyToOne
        val teacher: Teacher,

        @OneToOne
        val meetingSchedule: MeetingSchedule
)