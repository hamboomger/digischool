package com.digischool.util

import javafx.beans.property.BooleanProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleSetProperty
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.scene.control.PasswordField
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

fun <T> observableList(list: List<T>?): SimpleListProperty<T> {
    return SimpleListProperty(FXCollections.observableArrayList(list ?: emptyList()))
}

fun <T> observableSet(set: Set<T>?): SimpleSetProperty<T> {
    return SimpleSetProperty(FXCollections.observableSet(set ?: emptySet()))
}

fun PasswordField.requirements(minLength: Int) {
    validator {
        if (it == null || it.length < minLength) {
            error("You should have at least 5 symbols")
        } else null
    }
}