package com.digischool.interest_group

import com.digischool.util.observableSet
import tornadofx.*

/**
 * @author ddorochov
 */
class InterestGroupModel(): ItemViewModel<InterestGroup>() {
    constructor(interestGroup: InterestGroup) : this() {
        item = interestGroup
    }

    val subject = bind { item?.observable(InterestGroup::subject) }
    val students = observableSet(item?.students)
    val meetingSchedules = observableSet(item?.meetingSchedules)
}