package ru.mityushkin.usersbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["ru.mityushkin"], exclude = [SecurityAutoConfiguration::class]
)
class UsersBackendApplication

fun main(args: Array<String>) {
    runApplication<UsersBackendApplication>(*args)
}
