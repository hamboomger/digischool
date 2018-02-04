package com.digischool.view.auth.registration

import com.digischool.model.User
import tornadofx.*

/**
 * @author ddorochov
 */
class UserCredentialsForm : View("Credentials") {
    private val user: CredentialsModel by inject()

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

    class CredentialsModel : ItemViewModel<User>() {
        val login = bind { item?.observable(User::login) }
        val password = bind { item?.observable(User::password) }
    }

}