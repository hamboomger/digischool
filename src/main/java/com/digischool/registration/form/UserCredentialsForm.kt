package com.digischool.registration.form

import com.digischool.registration.RegistrationController
import com.digischool.user.User
import com.digischool.user.UsersManager
import com.digischool.util.requirements
import tornadofx.*

/**
 * @author ddorochov
 */
class UserCredentialsForm : View("Credentials") {
    private val usersManager: RegistrationController by inject()
    private val user: UserCredentialsModel by inject()

    override val root = form {
        fieldset("Credentials") {
            field("Login") {
                textfield(user.login) {
                    required()
                    validator { checkLoginAlreadyInUse(it) }
                }
            }

            field("Password") {
                passwordfield(user.password) {
                    required()
                    requirements(minLength = 5)
                }
            }
        }
    }

    private fun ValidationContext.checkLoginAlreadyInUse(it: String?): ValidationMessage? {
        return if (it != null && usersManager.containsStudentWithLogin(it)) {
            error("Login is already in use")
        } else null
    }

    class UserCredentialsModel : ItemViewModel<User>() {
        val login = bind { item?.observable(User::login) }
        val password = bind { item?.observable(User::password) }
    }

    override fun onSave() {
        isComplete = user.commit()
    }

}