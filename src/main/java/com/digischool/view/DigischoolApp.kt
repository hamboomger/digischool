package com.digischool.view

import com.digischool.view.auth.LoginForm
import tornadofx.*

/**
 * @author ddorochov
 */
class DigischoolApp : App(LoginView::class)

class LoginView : View() {
    override val root = borderpane {
        center(LoginForm::class)
    }

//    val loginForm: LoginForm by inject()

//    init {
//        with(root) {
//            center = loginForm.root
//        }
//    }
}