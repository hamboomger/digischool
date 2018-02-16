package com.digischool.registration

import com.digischool.registration.form.PersonalDataForm
import com.digischool.registration.form.StudentIndexGenerationForm
import com.digischool.registration.form.UserCredentialsForm
import com.digischool.user.Student
import com.digischool.user.StudentModel
import tornadofx.Wizard

/**
 * @author ddorochov
 */
class StudentRegistrationWizard : Wizard("Registration", "Students registration form") {
    val registrationController: RegistrationController by di()

    val personalDataModel: PersonalDataForm.PersonalDataModel by inject()
    val userCredentialsModel: UserCredentialsForm.UserCredentialsModel by inject()

    val studentModel: StudentModel by inject()

    val student = Student()

    init {
        graphic = resources.imageview("/img/user_plus.png")
        personalDataModel.item = student
        userCredentialsModel.item = student
        studentModel.item = student

        root.prefWidth = 500.0
        root.prefHeight = 500.0

        add(PersonalDataForm::class)
        add(UserCredentialsForm::class)
        add(StudentIndexGenerationForm::class)
    }

    override fun onSave() {
        registrationController.registerStudent(student)
        replaceWith(StudentPersonalDataView::class)
    }
    
}