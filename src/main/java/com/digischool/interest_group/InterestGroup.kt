package com.digischool.interest_group

import com.digischool.entity.MeetingSchedule
import com.digischool.entity.Subject
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
        val id: Int? = null,

        var name: String,

        @ManyToMany(targetEntity = Student::class, fetch = FetchType.EAGER)
        var students: MutableSet<Student> = mutableSetOf(),

        @ManyToOne
        var subject: Subject,

        @ManyToOne
        var teacher: Teacher? = null,

        @OneToMany(targetEntity = MeetingSchedule::class)
        var meetingSchedules: MutableSet<MeetingSchedule> = mutableSetOf()

) {

    constructor() : this(null, "", mutableSetOf(), Subject(), null)
}