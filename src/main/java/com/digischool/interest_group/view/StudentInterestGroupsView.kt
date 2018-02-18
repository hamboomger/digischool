package com.digischool.interest_group.view

import com.digischool.interest_group.InterestGroup
import com.digischool.user.StudentModel
import com.digischool.util.tableview
import tornadofx.*

class StudentInterestGroupsView : View("Interest groups") {
    val student: StudentModel by inject()

    override val root = vbox {
        button("Create") {
            fitToParentWidth()
            action {
                find(CreateInterestGroupView::class).openWindow()
            }
        }

        tableview(student.interestGroups) {
            column("name", InterestGroup::name)
            column("subject", InterestGroup::subject)
        }

        style {
            backgroundColor += c("aaa")
        }
    }

    init {
        root.minWidth = 150.0
    }

}