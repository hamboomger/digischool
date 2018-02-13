package com.digischool.student.view

import com.digischool.user.StudentModel
import com.digischool.util.editableTextField
import com.digischool.util.inverse
import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

/**
 * @author ddorochov
 */
class StudentPersonalDataView : View("Personal data") {
    val student: StudentModel by inject()
    val toggleEdit = SimpleBooleanProperty(false)

    override val root = form {
        fieldset {
            field("Name:")      .editableTextField(student.name, toggleEdit)
            field("Surname:")   .editableTextField(student.surname, toggleEdit)
            field("Email:")     .editableTextField(student.email, toggleEdit)
            field("Login:")     .editableTextField(student.login, toggleEdit)
            field("Index:")     .label(student.index)

            button("Edit") {
                removeWhen(toggleEdit)
                action { toggleEdit.inverse() }
            }
            button("Save") {
                removeWhen(toggleEdit.not())
                action { toggleEdit.inverse() }
            }

        }
    }

    init {
        root.minWidth = 300.0
        root.minHeight = 300.0
    }

}