package com.digischool.view.auth

import com.digischool.dto.UserCredentials
import tornadofx.*

/**
 * @author ddorochov
 */
class LoginForm : View("Login") {
    private val userModel = UserCredentialsModel(UserCredentials("ala", "ma cota"))

    override val root = form {
        fieldset("User credentials") {
            field("Login") {
                textfield().bind(userModel.login)
            }

            field("Password") {
                passwordfield().bind(userModel.password)
            }

            button("Save") {
                enableWhen(userModel.dirty)

            }
        }
    }

    class UserCredentialsModel(val user: UserCredentials) : ViewModel() {
        val login = bind { user.loginProperty() }
        val password = bind { user.passwordProperty() }
    }

}