package com.digischool.view.auth

import tornadofx.*

/**
 * @author ddorochov
 */
class LoginForm : View() {
    override val root = vbox {
        hbox {
            label("First Name")
            textfield()
        }
        hbox {
            label("Last Name")
            textfield()
        }
    }
}