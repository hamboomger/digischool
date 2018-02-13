package com.digischool.subject

import com.digischool.entity.Subject
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * @author ddorochov
 */
@Repository
interface SubjectsRepository : CrudRepository<Subject, Int>