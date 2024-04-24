package ru.mityushkin.usersbackend.persistence.entity

import jakarta.persistence.*
import ru.mityushkin.usersbackend.controllers.dto.UserResponse
import ru.mityushkin.usersbackend.persistence.entity.base.BaseAuditSoftDeleteEntity

@Entity
@Table(name = "users")
class User(
    var name: String,
    var surname: String? = null,
    var email: String,
    var password: String,
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: MutableSet<Role> = mutableSetOf()
) : BaseAuditSoftDeleteEntity() {
    fun toResponse(): UserResponse = UserResponse(this.name, this.surname, this.email)
}