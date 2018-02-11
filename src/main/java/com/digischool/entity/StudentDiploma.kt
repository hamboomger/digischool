package com.digischool.entity

import com.digischool.user.Student
import java.math.BigDecimal

/**
 * @author ddorochov
 */
class StudentDiploma(
        val student: Student,
        val diploma: Diploma,
        val gradePointAverage: BigDecimal
)