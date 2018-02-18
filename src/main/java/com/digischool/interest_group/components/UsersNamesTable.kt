package com.digischool.interest_group.components

import com.digischool.user.User
import javafx.beans.property.SimpleSetProperty
import javafx.collections.ObservableList
import javafx.scene.control.TableView
import tornadofx.*

/**
 * @author ddorochov
 */
class UsersNamesTable(items: ObservableList<User>) : TableView<User>(items) {

    constructor(items: SimpleSetProperty<out User>) : this(items.toMutableList().observable())

    init {
        column("Name", User::name)
        column("Surname", User::surname)

        maxHeight = 150.0
    }
}