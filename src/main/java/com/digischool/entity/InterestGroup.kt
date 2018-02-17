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

        @ManyToMany(targetEntity = Student::class, fetch = FetchType.EAGER)
        var students: MutableSet<Student> = mutableSetOf(),

        @ManyToOne
        var subject: Subject,

        @ManyToOne
        var teacher: Teacher,

        @OneToOne
        var meetingSchedule: MeetingSchedule
)