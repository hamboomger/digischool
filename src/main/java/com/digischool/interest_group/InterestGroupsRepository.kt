package com.digischool.interest_group

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * @author ddorochov
 */
@Repository
interface InterestGroupsRepository : CrudRepository<InterestGroup, Int>