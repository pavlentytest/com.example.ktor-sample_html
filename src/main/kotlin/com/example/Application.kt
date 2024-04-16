package com.example

import com.example.plugins.*
import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.mustache.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates")
    }// подключение шаблонизатора
    configureSerialization()
    configureRouting()
}
