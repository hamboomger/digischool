package com.digischool.registration.form

import com.digischool.entity.Student
import javafx.util.converter.NumberStringConverter
import tornadofx.*

/**
 * @author ddorochov
 */
class StudentIndexGenerationForm: View() {
    val student: StudentIndexModel by inject()

    override val root = form {
        fieldset {
            field("Generate index") {
//                textfield(student.index, NumberStringConverter())
            }
        }
    }

    class StudentIndexModel: ItemViewModel<Student>() {
        val index = bind { item.observable(Student::index) }
    }

}