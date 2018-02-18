package com.digischool.interest_group.view

import com.digischool.entity.MeetingSchedule
import com.digischool.interest_group.InterestGroupModel
import com.jfoenix.controls.JFXTimePicker
import javafx.beans.property.SimpleObjectProperty
import javafx.geometry.Insets
import javafx.geometry.Pos
import tornadofx.*
import java.time.DayOfWeek
import java.time.LocalTime

/**
 * @author ddorochov
 */
class CreateMeetingView : View("Meeting schedule") {
    val interestGroup: InterestGroupModel by inject()

    val timePicker = JFXTimePicker()
    val dayOfWeekProperty = SimpleObjectProperty<DayOfWeek>(DayOfWeek.MONDAY)

    override val root = vbox(spacing = 10) {
        padding = Insets(15.0)

        timePicker.value = LocalTime.MIDNIGHT

        vbox(spacing = 5) {
            label("Day of week:")
            combobox(dayOfWeekProperty, DayOfWeek.values().asList())
        }

        vbox {
            label("Time:")
            add(timePicker)
        }

        vbox(alignment = Pos.CENTER) {
            button("Add") {
                action {
                    val meetingSchedule = MeetingSchedule(
                            interestGroup = interestGroup.item,
                            meetingDays = mutableListOf(dayOfWeekProperty.get()),
                            meetingTime = timePicker.value)

                    interestGroup.meetingSchedules.add(meetingSchedule)
                    currentStage?.close()
                }
            }
        }

    }

}