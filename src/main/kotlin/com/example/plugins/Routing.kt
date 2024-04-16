package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.mustache.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*


data class User(val name: String, val age: Int)
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/helloivan") {
            val userOlga = User("Olga",20)
            call.respond(MustacheContent("test.hbs", mapOf("user" to userOlga)))
        }

        get("/html") {
            call.respondHtml(HttpStatusCode.OK) {
                head {
                    title {
                        + "Example of title"
                    }
                }
                body{
                    h1 {
                        + "Test server!"
                    }
                }
            }
        }
    }
}
