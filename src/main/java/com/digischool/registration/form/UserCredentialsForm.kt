package com.digischool.registration.form

import com.digischool.user.User
import tornadofx.*

/**
 * @author ddorochov
 */
class UserCredentialsForm : View("Credentials") {
    private val user: UserCredentialsModel by inject()

    override val root = form {
        fieldset("Credentials") {
            field("Login") {
                textfield(user.login).required()
            }
            field("Password") {
                passwordfield(user.password).required()
            }
        }
    }

    class UserCredentialsModel : ItemViewModel<User>() {
        val login = bind { item?.observable(User::login) }
        val password = bind { item?.observable(User::password) }
    }

}