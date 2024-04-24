package ru.mityushkin.usersbackend.config.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import ru.mityushkin.usersbackend.persistence.entity.User

class UserDetailsConfig(private val userDetails: User
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return userDetails
            .roles
            .map { SimpleGrantedAuthority(it.name) }
            .toMutableList()
    }

    override fun getPassword(): String {
        return userDetails.password
    }

    override fun getUsername(): String {
        return userDetails.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}