package com.digischool.registration.form

import com.digischool.registration.RegistrationController
import com.digischool.user.StudentModel
import com.digischool.user.UsersManager
import javafx.util.converter.IntegerStringConverter
import tornadofx.*

/**
 * @author ddorochov
 */
class StudentIndexGenerationForm: View("Generate index") {
    val student: StudentModel by inject()
    val usersManager: RegistrationController by inject()

    override val root = form {
        fieldset {
            field("Your index: ") {
                textfield(student.index, IntegerStringConverter()) {
                    isEditable = false
                }

                button("Generate").action {
                    generateAndSetIndex()
                }
            }
        }
        // set by default
        generateAndSetIndex()
    }

    private fun generateAndSetIndex() {
        student.index.setValue(usersManager.generateStudentIndex())
    }

    override fun onSave() {
        isComplete = student.commit(student.index)
    }

}