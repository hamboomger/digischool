package com.digischool.util

import javafx.beans.property.BooleanProperty
import javafx.beans.property.ReadOnlyListProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleSetProperty
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.event.EventTarget
import javafx.scene.control.ListView
import javafx.scene.control.PasswordField
import javafx.scene.control.TableView
import javafx.scene.layout.Pane
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
    return SimpleListProperty(FXCollections.observableArrayList(list ?: mutableListOf()))
}

fun <T> observableSet(set: Set<T>?): SimpleSetProperty<T> {
    return SimpleSetProperty(FXCollections.observableSet(set ?: mutableSetOf()))
}

fun <T> EventTarget.tableview(items: SimpleSetProperty<T>, op: TableView<T>.() -> Unit = {}) {
    tableview(items.toMutableList().observable(), op)
}

fun PasswordField.requirements(minLength: Int) {
    validator {
        if (it == null || it.length < minLength) {
            error("You should have at least 5 symbols")
        } else null
    }
}

fun <T> Pane.listview(values: SimpleSetProperty<T>, op: ListView<T>.() -> Unit = {}) {
    val listValues = FXCollections.observableArrayList(values.toMutableList())
    listview(listValues, op)
}