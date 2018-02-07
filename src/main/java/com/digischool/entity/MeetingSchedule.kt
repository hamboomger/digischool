package com.digischool.entity

import java.time.DayOfWeek
import java.time.LocalDate
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
        val cancelledMeetings: List<LocalDate>
)