package com.digischool.registration

import com.digischool.registration.form.PersonalDataForm
import com.digischool.registration.form.UserCredentialsForm
import tornadofx.Wizard

/**
 * @author ddorochov
 */
class StudentRegistrationWizard : Wizard("Registration", "Students registration form") {
    init {
        root.prefWidth = 500.0
        root.prefHeight = 500.0

        add(PersonalDataForm::class)
        add(UserCredentialsForm::class)
    }
}