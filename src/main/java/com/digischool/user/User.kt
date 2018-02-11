package com.digischool.user

import javax.persistence.*

/**
 * @author ddorochov
 */
@MappedSuperclass
open class User(
        @Id
        @GeneratedValue
        var id: Int?,
        var name: String,
        var surname: String,

        @Column(unique = true)
        var email: String,

        @Column(unique = true)
        var login: String,
        var password: String
) {
    /** Empty constructor */
    constructor() : this(null, "", "", "", "", "")
}