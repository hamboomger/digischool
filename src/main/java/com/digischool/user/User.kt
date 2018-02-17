package com.digischool.user

import javax.persistence.*

/**
 * @author ddorochov
 */
@MappedSuperclass
open class User(
        @Id
        @GeneratedValue
        open var id: Int? = null,
        open var name: String,
        open var surname: String,

        @Column(unique = true)
        open var email: String,

        @Column(unique = true)
        open var login: String,
        open var password: String
) {
    /** Empty constructor */
    constructor() : this(null, "", "", "", "", "")
}