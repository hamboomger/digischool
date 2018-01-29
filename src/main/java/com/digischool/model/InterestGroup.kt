package com.digischool.model

/**
 * @author ddorochov
 */
class InterestGroup(
        val students: List<Student>,
        val subject: Subject,
        val teacher: Teacher,
        val meetingSchedule: MeetingSchedule
)