package com.digischool.interest_group

import org.springframework.stereotype.Service

/**
 * @author ddorochov
 */
@Service
interface InterestGroupsManager {
    fun saveInterestGroup(interestGroup: InterestGroup)
}