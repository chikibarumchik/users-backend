package ru.mityushkin.usersbackend.config.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.mityushkin.usersbackend.persistence.repositories.UserRepository

@Service
class UserDetailsService(
    private val userRepository: UserRepository,
): UserDetailsService {
    override fun loadUserByUsername(login: String?): UserDetails {
        val crmUserDetails = userRepository.getByEmail(login)
        return crmUserDetails?.let { UserDetailsConfig(it) } ?: throw UsernameNotFoundException(login + "not found")
    }

}