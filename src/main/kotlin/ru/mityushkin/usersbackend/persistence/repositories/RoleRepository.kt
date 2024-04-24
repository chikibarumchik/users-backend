package ru.mityushkin.usersbackend.persistence.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mityushkin.usersbackend.persistence.entity.Role

@Repository
interface RoleRepository: JpaRepository<Role, Long> {
    fun getByName(name: String): Role
}