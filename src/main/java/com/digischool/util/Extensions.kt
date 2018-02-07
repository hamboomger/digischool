package com.digischool.util

import java.util.*

/**
 * @author ddorochov
 */
fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) +  start
