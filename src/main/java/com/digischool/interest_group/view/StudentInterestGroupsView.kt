package com.digischool.interest_group.view

import tornadofx.View
import tornadofx.button
import tornadofx.fitToParentSize
import tornadofx.vbox

class StudentInterestGroupsView : View("Interest groups") {
    override val root = vbox {
        button("Create") {
            fitToParentSize()

        }
    }
}