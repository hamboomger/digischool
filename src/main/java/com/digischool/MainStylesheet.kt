package com.digischool

import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import tornadofx.*
import javax.swing.text.html.CSS

class MainStylesheet : Stylesheet() {
    companion object {
        val header by cssclass()
    }

    init {
        header {
            fontWeight = FontWeight.BOLD
            textAlignment = TextAlignment.CENTER
        }
        field {
            fontSize = 11.pt
        }
        label {
            fontSize = 11.pt
        }
    }
}