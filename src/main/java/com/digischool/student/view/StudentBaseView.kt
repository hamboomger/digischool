package com.digischool.student.view

import com.digischool.interest_group.view.StudentInterestGroupsView
import tornadofx.View
import tornadofx.borderpane
import tornadofx.tabpane

class StudentBaseView : View() {
    override var root = tabpane {
        borderpane {
            heading = "Personal data"
            center(StudentPersonalDataView::class)
            right(StudentInterestGroupsView::class)
        }
    }
}