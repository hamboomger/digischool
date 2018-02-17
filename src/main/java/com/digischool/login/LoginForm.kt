package com.digischool.login

import com.digischool.registration.StudentRegistrationWizard
import com.digischool.student.view.StudentBaseView
import com.digischool.user.StudentModel
import javafx.geometry.Pos
import javafx.scene.control.ButtonType
import tornadofx.*
import java.lang.UnsupportedOperationException

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
                    find<StudentRegistrationWizard>().openWindow()
                }

                button("Log in") {
                    enableWhen(userModel.valid)

                    action {
                        if(authoriseUser()) {
                            find<StudentBaseView>().openWindow(owner = null)
                            currentStage?.close()
                        } else {
                            information("User or password is incorrect", buttons = ButtonType.OK)
                        }
                    }

                }

                style {
                    alignment = Pos.CENTER_RIGHT
                }
            }

        }
    }

    private fun authoriseUser() : Boolean {
        userModel.commit()
        if(!userModel.isTeacher.value) {
            val student = authController.authoriseStudent(
                    userModel.login.value, userModel.password.value) ?: return false

            val studentModel = authController.createNewStudentModel(student)
            setInScope(studentModel)
            return true
        } else {
            throw UnsupportedOperationException("Teacher page is not implemented yet")
        }
    }

    init {
        icon = resources.imageview("/img/user_circle.png")
        userModel.validate(decorateErrors = false)
    }

    class UserCredentialsModel(val user: UserLoginCredentials) : ViewModel() {
        val login = bind { user.loginProperty() }
        val password = bind { user.passwordProperty() }
        val isTeacher = bind { user.isTeacherProperty() }
    }

}