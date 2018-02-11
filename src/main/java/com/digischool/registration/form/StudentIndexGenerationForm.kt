package com.digischool.registration.form

import com.digischool.user.Student
import com.digischool.user.StudentModel
import com.digischool.user.UsersManager
import javafx.util.converter.IntegerStringConverter
import tornadofx.*
/**
 * @author ddorochov
 */
class StudentIndexGenerationForm: View() {
    val student: StudentModel by inject()
    val usersManager: UsersManager by di()

    override val root = form {
        fieldset {
            field("Generate index") {
                textfield(student.index, IntegerStringConverter())
                button("Generate").action {
                    student.index.setValue(usersManager.generateStudentIndex())
                }
            }
        }
    }

    override fun onSave() {
        isComplete = student.commit(student.index)
    }

}

