package com.digischool.model

import java.math.BigDecimal

/**
 * @author ddorochov
 */
class StudentDiploma(
        val student: Student,
        val diploma: Diploma,
        val gradePointAverage: BigDecimal
)