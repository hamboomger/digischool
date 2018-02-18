package com.digischool.interest_group.view

import com.digischool.entity.Subject
import com.digischool.interest_group.InterestGroup
import com.digischool.interest_group.InterestGroupModel
import com.digischool.subject.SubjectsManager
import com.digischool.user.StudentModel
import javafx.beans.property.SimpleObjectProperty
import javafx.geometry.Pos
import tornadofx.*

/**
 * @author ddorochov
 */
class CreateInterestGroupView : View("Select subject") {
    val selectedSubject = SimpleObjectProperty<Subject>()
    val studentModel: StudentModel by inject()
    val subjectsManager: SubjectsManager by di()

    override val root = form {
        fieldset() {
            val allSubjects = subjectsManager.getAllSubjects().observable()
            selectedSubject.set(allSubjects[0])

            field("Select the subject") {
                combobox(selectedSubject, allSubjects) {
                    cellFormat { text = it.name }
                }
            }

            button("Ok") {
                action {
                    val student = studentModel.item
                    val interestGroup = InterestGroup(
                            students = mutableSetOf(student),
                            subject = selectedSubject.value
                    )
                    setInScope(InterestGroupModel(interestGroup))
                    find(InterestGroupView::class).openWindow(owner = null)
                    currentStage?.close()
                }
                alignment = Pos.CENTER
            }
        }
    }
}