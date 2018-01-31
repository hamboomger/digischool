package com.digischool

import com.digischool.view.auth.LoginFormView
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import tornadofx.App
import tornadofx.DIContainer
import tornadofx.FX
import kotlin.reflect.KClass

/**
 * @author ddorochov
 */
class DigischoolApp : App(LoginFormView::class) {

    init {
        val springContext = AnnotationConfigApplicationContext("com.digischool")
        // setting spring context as a default DI container in TornadoFX
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T = springContext.getBean(type.java)
            override fun <T : Any> getInstance(type: KClass<T>, name: String): T = springContext.getBean(type.java,name)
        }
    }

}