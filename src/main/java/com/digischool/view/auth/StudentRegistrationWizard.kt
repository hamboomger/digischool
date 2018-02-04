package com.digischool.view.auth

import com.digischool.view.auth.registration.PersonalDataForm
import com.digischool.view.auth.registration.UserCredentialsForm
import tornadofx.Wizard

/**
 * @author ddorochov
 */
class StudentRegistrationWizard : Wizard("Registration", "Students registration form") {
    init {
        add(PersonalDataForm::class)
        add(UserCredentialsForm::class)
    }
}