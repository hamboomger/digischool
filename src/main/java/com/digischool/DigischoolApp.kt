package com.digischool

import com.digischool.login.LoginForm
import javafx.scene.Scene
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import tornadofx.*
import kotlin.reflect.KClass

/**
 * @author ddorochov
 */
@SpringBootApplication
@EnableJpaRepositories
class DigischoolApp : App(LoginForm::class, MainStylesheet::class) {

    override fun init() {
        val springContext = SpringApplication.run(DigischoolApp::class.java)
        // setting spring context as a default DI container in TornadoFX
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T = springContext.getBean(type.java)
            override fun <T : Any> getInstance(type: KClass<T>, name: String): T = springContext.getBean(type.java,name)
        }
        reloadStylesheetsOnFocus()
        reloadViewsOnFocus()
    }

    override fun createPrimaryScene(view: UIComponent): Scene {
        return super.createPrimaryScene(view)
    }

}