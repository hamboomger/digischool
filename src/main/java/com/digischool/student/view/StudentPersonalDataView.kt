package com.digischool.student.view

import com.digischool.user.StudentModel
import tornadofx.*

/**
 * @author ddorochov
 */
class StudentPersonalDataView : View() {
    val student: StudentModel by inject()

    override val root = form {
        fieldset {
            field("Name").label()
        }
    }
}