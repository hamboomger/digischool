package com.digischool.registration.form

import com.digischool.registration.RegistrationController
import com.digischool.user.User
import com.digischool.user.UsersManager
import tornadofx.*

/**
 * @author ddorochov
 */
class PersonalDataForm : View("Personal data") {

    private val usersManager: RegistrationController by inject()

    private val user: PersonalDataModel by inject()

    override val root = form {
        fieldset("Personal data") {

            field("Name") {
                textfield(user.name).required()
            }

            field("Surname") {
                textfield(user.surname).required()
            }

            field("Email") {
                textfield(user.email) {
                    required()
                    validator { checkEmailAlreadyInUse(it) }
                }
            }

        }
    }

    private fun ValidationContext.checkEmailAlreadyInUse(it: String?): ValidationMessage? {
        return if (it != null && usersManager.containsStudentWithEmail(it)) {
            error("User with such email address already exists")
        } else null
    }

    class PersonalDataModel: ItemViewModel<User>() {
        val name = bind { item?.observable(User::name) }
        val surname = bind { item?.observable(User::surname) }
        val email = bind { item?.observable(User::email) }
    }

    override fun onSave() {
        isComplete = user.commit()
    }

}