package com.digischool.entity

import com.digischool.interest_group.InterestGroup
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

/**
 * @author ddorochov
 */
@Entity
class MeetingSchedule(
    @Id
    @GeneratedValue
    var id: Int? = null,

    @OneToOne
    var interestGroup: InterestGroup,

    @ElementCollection
    var meetingDays: MutableList<DayOfWeek> = mutableListOf(),

    var meetingTime: LocalTime,

    var place: String
)