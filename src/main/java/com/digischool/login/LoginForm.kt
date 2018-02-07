package com.digischool.login

import com.digischool.registration.StudentRegistrationWizard
import javafx.geometry.Pos
import tornadofx.*

/**
 * @author ddorochov
 */
class LoginForm : View("Login") {
    private val authController: AuthorizationController by di()
    private val userModel = UserCredentialsModel(UserLoginCredentials())

    override val root = form {
        fieldset("User credentials") {
            field("Login") {
                textfield(userModel.login).required()
            }

            field("Password") {
                passwordfield(userModel.password).required()
            }

            checkbox("I'm a teacher", userModel.isTeacher)

            hbox {
                hyperlink("Sign up").action {
                    close()
                    find<StudentRegistrationWizard>().openWindow()
                }

                button("Log in") {
                    enableWhen(userModel.valid)
                    action {

                    }
                }

                alignment = Pos.CENTER_RIGHT
            }

        }
    }

    init {
        userModel.validate(decorateErrors = false)
    }

    class UserCredentialsModel(val user: UserLoginCredentials) : ViewModel() {
        val login = bind { user.loginProperty() }
        val password = bind { user.passwordProperty() }
        val isTeacher = bind { user.isTeacherProperty() }
    }

}