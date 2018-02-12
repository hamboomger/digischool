package com.digischool.student.view

import tornadofx.View
import tornadofx.tabpane

class StudentBaseView : View() {
    override var root = tabpane {
        add(StudentPersonalDataView::class)
    }
}