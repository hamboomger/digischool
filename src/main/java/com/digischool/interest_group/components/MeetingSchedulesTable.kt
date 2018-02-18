package com.digischool.interest_group.components

import com.digischool.entity.MeetingSchedule
import javafx.beans.property.SimpleSetProperty
import javafx.collections.ObservableList
import javafx.scene.control.TableView
import tornadofx.*
import java.time.format.TextStyle
import java.util.*

/**
 * @author ddorochov
 */
class MeetingSchedulesTable(items: ObservableList<MeetingSchedule>) : TableView<MeetingSchedule>(items) {
    constructor(items: SimpleSetProperty<MeetingSchedule>) : this(items.toMutableList().observable())

    init {
        column("Time", MeetingSchedule::meetingTime)
        column("Days", MeetingSchedule::meetingDays).cellFormat { meetingDays ->
            text = meetingDays.map {
                it.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
            }.joinToString()
        }

        maxHeight = 150.0
    }
}