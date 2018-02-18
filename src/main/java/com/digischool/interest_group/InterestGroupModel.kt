package com.digischool.interest_group

import com.digischool.util.observableSet
import tornadofx.*

/**
 * @author ddorochov
 */
class InterestGroupModel(interestGroup: InterestGroup?): ItemViewModel<InterestGroup>() {
    init {
        item = interestGroup
    }
    constructor() : this(InterestGroup())

    val name = bind { item?.observable(InterestGroup::name) }
    val subject = bind { item?.observable(InterestGroup::subject) }
    val students = observableSet(item?.students)
    val meetingSchedules = observableSet(item?.meetingSchedules)
}