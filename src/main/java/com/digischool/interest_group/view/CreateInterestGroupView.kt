package com.digischool.interest_group.view

import com.digischool.interest_group.InterestGroup
import com.digischool.interest_group.InterestGroupModel
import com.digischool.subject.SubjectsManager
import com.digischool.user.StudentModel
import com.digischool.user.UsersManager
import javafx.geometry.Pos
import tornadofx.*

/**
 * @author ddorochov
 */
class CreateInterestGroupView : View("Create new interest group") {
    val subjectsManager: SubjectsManager by di()
    val usersManager: UsersManager by di()

    val studentModel: StudentModel by inject()
    val interestGroup: InterestGroupModel by inject(overrideScope = scope)

    override val root = vbox(spacing = 10, alignment = Pos.CENTER) {
        val allSubjects = subjectsManager.getAllSubjects().observable()

        vbox {
            label("Enter name:")
            textfield(interestGroup.name).required()
        }

        vbox {
            label("Select the subject:")
            combobox(interestGroup.subject, allSubjects) {
                cellFormat { text = it.name }
            }.required()

            interestGroup.subject.value = allSubjects[0] // set default value
        }

        button("Ok") {
            action {
                val student = studentModel.item
                interestGroup.students.add(student)
                find(InterestGroupView::class).openWindow(owner = null)
                currentStage?.close()
            }
            enableWhen(interestGroup.valid)
            alignment = Pos.CENTER
        }

        style {
            padding = box(10.px)
            minWidth = 200.px
        }
    }
}