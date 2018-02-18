package com.digischool.student.view

import com.digischool.interest_group.view.StudentInterestGroupsView
import javafx.scene.Parent
import tornadofx.*

class StudentBaseView : View() {
    override var root = tabpane {
        add(PersonalDataTab::class)
    }

    class PersonalDataTab : View("Personal data") {
        override val root = borderpane() {
            heading = "Personal data"
            center(StudentPersonalDataView::class)
            right(StudentInterestGroupsView::class)
        }
    }
}