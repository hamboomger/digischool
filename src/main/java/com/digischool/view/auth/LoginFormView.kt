package com.digischool.view.auth

import tornadofx.*

/**
 * @author ddorochov
 */
class LoginFormView : View("Login") {
    private val userModel = UserCredentialsModel(UserCredentials())

    override val root = form {
        fieldset("User credentials") {
            field("Login") {
                textfield(userModel.login) {
                    required()
                }
            }

            field("Password") {
                passwordfield(userModel.password).required()
            }

            button("Save") {
                enableWhen(userModel.valid)
            }

        }
    }

    init {
        userModel.validate(decorateErrors = false)
        setWindowMinSize(400, 150)
    }

    class UserCredentialsModel(val user: UserCredentials) : ViewModel() {
        val login = bind { user.loginProperty() }
        val password = bind { user.passwordProperty() }
    }

}