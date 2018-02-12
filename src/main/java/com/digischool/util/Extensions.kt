package com.digischool.util

import javafx.beans.property.BooleanProperty
import javafx.beans.value.ObservableValue
import tornadofx.*
import java.util.*

/**
 * @author ddorochov
 */
fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) +  start

fun Field.editableTextField(property: ObservableValue<String>, toggleEdit: BooleanProperty) {
    textfield(property).removeWhen(toggleEdit.not())
    label(property).removeWhen(toggleEdit)
}

fun BooleanProperty.inverse() {
    value = !value
}