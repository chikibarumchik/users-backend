package ru.mityushkin.usersbackend.services

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.mityushkin.usersbackend.controllers.dto.UserRequest
import ru.mityushkin.usersbackend.persistence.entity.User
import ru.mityushkin.usersbackend.persistence.repositories.RoleRepository
import ru.mityushkin.usersbackend.persistence.repositories.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val roleRepository: RoleRepository
) {
    fun registrationNewUser(userRq: UserRequest): User {
        val passwordUserEncode = passwordEncoder.encode(userRq.password)
        val role = roleRepository.getByName("USER")
        return User(userRq.name, userRq.surname, userRq.email, passwordUserEncode, mutableSetOf(role))
            .also { userRepository.save(it) }
    }
}