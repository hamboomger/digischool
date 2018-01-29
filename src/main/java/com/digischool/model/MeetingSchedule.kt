package com.digischool.model

import java.time.DayOfWeek
import java.time.LocalDate

/**
 * @author ddorochov
 */
class MeetingSchedule(
        val meetingDays: List<DayOfWeek>,
        val cancelledMeetings: List<LocalDate>
)