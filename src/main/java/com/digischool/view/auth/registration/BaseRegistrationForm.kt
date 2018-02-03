package com.digischool.view.auth.registration

import com.digischool.model.User
import tornadofx.*

/**
 * @author ddorochov
 */
class BaseRegistrationForm : View() {
    val user = UserModel(User())

    override val root = form {
        fieldset("Personal data") {
            field("Name") {
                textfield(user.name).required()
            }
            field("Surname") {
                textfield(user.surname).required()
            }
            field("Email") {
                textfield(user.email).required()
            }
            field("Login") {
                textfield(user.login).required()
            }
            field("Password") {
                passwordfield(user.password).required()
            }        }
    }

    class UserModel(val user: User) : ViewModel() {
        val name = bind { user.observable(User::name) }
        val surname = bind { user.observable(User::surname) }
        val email = bind { user.observable(User::email) }
        val login = bind { user.observable(User::login) }
        val password = bind { user.observable(User::password) }
    }

}