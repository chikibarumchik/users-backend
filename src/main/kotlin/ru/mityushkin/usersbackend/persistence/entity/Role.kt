package ru.mityushkin.usersbackend.persistence.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import ru.mityushkin.usersbackend.persistence.entity.base.BaseAuditSoftDeleteEntity

@Entity
@Table(name = "roles")
class Role(
    var name: String,
    @ManyToMany(mappedBy = "roles", cascade = [CascadeType.ALL])
    var users: MutableSet<User> = mutableSetOf()
): BaseAuditSoftDeleteEntity() {
}