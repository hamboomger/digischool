package com.digischool.interest_group.view

import com.digischool.util.DayOfWeekPicker
import com.jfoenix.controls.JFXTimePicker
import tornadofx.View
import tornadofx.vbox

/**
 * @author ddorochov
 */
class CreateInterestGroupStep2 : View("Meeting schedule") {
    val interestGroupModel: InterestGroupModel by inject()

    val timePicker = JFXTimePicker()
    val dayOfWeekPicker = DayOfWeekPicker()

    override val root = vbox {
        add(timePicker)
        add(dayOfWeekPicker)
    }

    override fun onSave() {
        isComplete = interestGroupModel.commit()
    }

}