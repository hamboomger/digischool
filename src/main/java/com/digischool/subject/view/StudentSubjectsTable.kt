package com.digischool.subject.view

import com.digischool.subject.StudentSubjectStatus
import javafx.collections.ObservableList
import javafx.scene.control.TableView
import tornadofx.*

/**
 * @author ddorochov
 */
class StudentSubjectsTable(items: ObservableList<StudentSubjectStatus>) : TableView<StudentSubjectStatus>(items) {
    init {
        column<StudentSubjectStatus, String>("Name") {
            it.value.subject.name.toProperty()
        }
    }
}