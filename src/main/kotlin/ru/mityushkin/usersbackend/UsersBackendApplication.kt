package ru.mityushkin.usersbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UsersBackendApplication

fun main(args: Array<String>) {
    runApplication<UsersBackendApplication>(*args)
}
