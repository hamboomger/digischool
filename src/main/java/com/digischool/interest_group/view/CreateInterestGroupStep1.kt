package com.digischool.interest_group.view

import com.digischool.subject.SubjectsManager
import tornadofx.*

/**
 * @author ddorochov
 */
class CreateInterestGroupStep1: View() {
    val interestGroup: InterestGroupModel by inject()
    val subjectsManager: SubjectsManager by di()

    override val root = form {
        fieldset() {
            val allSubjects = subjectsManager.getAllSubjects().observable()
            combobox(interestGroup.subject, allSubjects) {
                cellFormat { text = it.name }
            }
        }
    }
}