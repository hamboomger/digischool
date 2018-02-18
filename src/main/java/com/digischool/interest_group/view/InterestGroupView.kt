package com.digischool.interest_group.view

import com.digischool.interest_group.InterestGroupModel
import com.digischool.util.listview
import javafx.scene.text.Font
import tornadofx.*

/**
 * @author ddorochov
 */
class InterestGroupView: View("Interest group") {
    val interestGroup: InterestGroupModel by inject()

    override val root = borderpane {
        left {
            label("Students")
            listview(interestGroup.students) {
                cellFormat { "${it.name} ${it.surname}" }
            }

        }

        right {
            label("Teacher")
            label("There is no teacher in this group")
        }

        bottom {
            label("Schedule")

        }
    }
}
