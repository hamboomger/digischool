package com.digischool.registration.form

import com.digischool.entity.User
import tornadofx.*

/**
 * @author ddorochov
 */
class PersonalDataForm : View("Personal data") {
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
                textfield(user.email).required()
            }
        }
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