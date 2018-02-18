package com.digischool.interest_group

import org.springframework.stereotype.Service

/**
 * @author ddorochov
 */
@Service
class InterestGroupsManagerImpl(val repository: InterestGroupsRepository) : InterestGroupsManager {
    override fun saveInterestGroup(interestGroup: InterestGroup) {
        repository.save(interestGroup)
    }
}