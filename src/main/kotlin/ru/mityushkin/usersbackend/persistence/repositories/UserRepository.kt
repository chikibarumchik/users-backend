package ru.mityushkin.usersbackend.persistence.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mityushkin.usersbackend.persistence.entity.User

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun getByEmail(email: String?): User?
}