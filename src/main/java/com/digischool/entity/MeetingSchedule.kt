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
        val id: Int,

        @OneToOne
        val interestGroup: InterestGroup,

        @ElementCollection
        val meetingDays: List<DayOfWeek>,

        @ElementCollection
        val meetingTime: LocalTime
)