package com.digischool.util

import javafx.geometry.Pos
import javafx.scene.control.CheckBox
import javafx.scene.layout.Pane
import tornadofx.*
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.*

/**
 * @author ddorochov
 */
class DayOfWeekPicker : Pane() {
    private val daysOfWeekButtons = mutableMapOf<CheckBox, DayOfWeek>()

    init {
        gridpane {
            for (dayOfWeek in DayOfWeek.values()) {
                row {
                    val button = checkbox(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
                    daysOfWeekButtons.put(button, dayOfWeek)
                    alignment = Pos.CENTER
                }
            }
        }
    }

    val selectedDays: List<DayOfWeek>
            get() = daysOfWeekButtons
                    .filterKeys { it.isSelected }
                    .map { it.value }

}