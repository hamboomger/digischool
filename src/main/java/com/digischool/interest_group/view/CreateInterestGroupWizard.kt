package com.digischool.interest_group.view

import com.digischool.interest_group.InterestGroup
import tornadofx.ItemViewModel
import tornadofx.Wizard
import tornadofx.observable

class CreateInterestGroupWizard: Wizard("Create interest group") {

    init {
        add(CreateInterestGroupStep1::class)
        add(CreateInterestGroupStep2::class)
    }

}

class InterestGroupModel : ItemViewModel<InterestGroup>() {
    var subject = bind { item.observable(InterestGroup::subject) }
    var meetingSchedules = bind { item.observable(InterestGroup::meetingSchedules) }
}