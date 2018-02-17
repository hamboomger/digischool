package com.digischool.util

import javafx.geometry.Pos
import javafx.scene.layout.Pane
import tornadofx.gridpane
import tornadofx.row
import tornadofx.togglebutton
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.*

/**
 * @author ddorochov
 */
class DayOfWeekPicker : Pane() {
    init {
        gridpane {
            for (dayOfWeek in DayOfWeek.values()) {
                row {
                    togglebutton(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
                    alignment = Pos.CENTER
                }
            }
        }
    }
}