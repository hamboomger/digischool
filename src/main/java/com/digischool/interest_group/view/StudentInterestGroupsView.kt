package com.digischool.interest_group.view

import com.digischool.registration.StudentRegistrationWizard
import tornadofx.*

class StudentInterestGroupsView : View("Interest groups") {

    override val root = vbox {
        button("Create") {
            fitToParentWidth()
            action {
                find(CreateInterestGroupView::class).openWindow()
            }
        }

        style {
            backgroundColor += c("aaa")
        }
    }

    init {
        root.minWidth = 150.0
    }

}