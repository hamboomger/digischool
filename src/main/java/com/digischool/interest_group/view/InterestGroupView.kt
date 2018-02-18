package com.digischool.interest_group.view

import com.digischool.MainStylesheet
import com.digischool.interest_group.InterestGroupModel
import com.digischool.interest_group.components.MeetingSchedulesTable
import com.digischool.interest_group.components.UsersNamesTable
import javafx.geometry.Pos
import javafx.scene.text.TextAlignment
import tornadofx.*

/**
 * @author ddorochov
 */
class InterestGroupView: View("Interest group") {
    val interestGroup: InterestGroupModel by inject()

    override val root = vbox {
        hbox {
            vbox {
                label("Students").addClass(MainStylesheet.header)
                add(UsersNamesTable(interestGroup.students))
            }
            vbox {
                label("Teacher").addClass(MainStylesheet.header)
                val teacher = interestGroup.item?.teacher
                label(teacher?.name ?: "There is no teacher in this group") {textAlignment = TextAlignment.LEFT}
            }
        }

        hbox {
            label("Schedule")
            button("Add") {
                action { find(CreateMeetingView::class).openWindow() }
            }
        }

        add(MeetingSchedulesTable(interestGroup.meetingSchedules))

        hbox(alignment = Pos.CENTER) {
            button("Ok") {
                currentStage?.close()
            }
        }
    }

    init {
        root.minWidth = 400.0
        root.minHeight = 400.0
    }

}