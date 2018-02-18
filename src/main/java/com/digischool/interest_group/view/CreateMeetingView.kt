package com.digischool.interest_group.view

import com.jfoenix.controls.JFXTimePicker
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*
import java.time.DayOfWeek
import java.time.LocalTime

/**
 * @author ddorochov
 */
class CreateMeetingView : View("Meeting schedule") {
    val timePicker = JFXTimePicker()
    val dayOfWeekProperty = SimpleObjectProperty<DayOfWeek>(DayOfWeek.MONDAY)

    override val root = vbox {
        timePicker.value = LocalTime.MIDNIGHT

        combobox(dayOfWeekProperty, DayOfWeek.values().asList())
        add(timePicker)
    }

    override fun onSave() {
        super.onSave()

//        val meetingSchedule = MeetingSchedule(
//                interestGroup = interestGroupModel.item,
//                meetingDays = mutableListOf(dayOfWeekProperty.get()),
//                meetingTime = timePicker.value)

//        interestGroupModel.meetingSchedules.value.add(meetingSchedule)
        isComplete = true
    }

}