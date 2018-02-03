package com.digischool.view.auth

import com.digischool.model.User
import com.digischool.view.auth.registration.BaseRegistrationForm
import tornadofx.Wizard

/**
 * @author ddorochov
 */
class RegistrationWizard : Wizard() {
    val user: User by inject()
}