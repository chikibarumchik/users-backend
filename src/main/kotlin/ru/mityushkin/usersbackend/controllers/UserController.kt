package ru.mityushkin.usersbackend.controllers

import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.mityushkin.usersbackend.controllers.dto.UserRequest
import ru.mityushkin.usersbackend.controllers.dto.UserResponse
import ru.mityushkin.usersbackend.services.UserService

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Сохранение региона")
    fun registration(
        @RequestBody rq: UserRequest
    ): UserResponse {
        return userService.registrationNewUser(rq).toResponse()
    }
}