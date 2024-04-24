package ru.mityushkin.usersbackend.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import ru.mityushkin.usersbackend.controllers.dto.UserRequest
import ru.mityushkin.usersbackend.controllers.dto.UserResponse
import ru.mityushkin.usersbackend.persistence.entity.Role
import ru.mityushkin.usersbackend.persistence.repositories.RoleRepository
import ru.mityushkin.usersbackend.services.UserService

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("test", "security_disabled")
class UserControllerTest {
    @MockBean
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var roleRepository: RoleRepository

    @Autowired
    private lateinit var userRepository: RoleRepository

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @AfterEach
    fun clear() {
        userRepository.deleteAll()
        roleRepository.deleteAll()
    }

    @Test
    fun `should create user`() {
        val userRequest = UserRequest("testName", "testSurname", "testEmail", "testPassword")
        Role("USER").also { roleRepository.save(it) }

        whenever(passwordEncoder.encode("testPassword"))
            .thenReturn("qwertasdlmnasljdnjasndlasd")

        val body = mockMvc.post("/api/v1/users/registration"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(userRequest)
        }
            .andDo {
                print()
            }.andExpect {
                status { isCreated() }
                content { contentType(MediaType.APPLICATION_JSON) }
            }.andReturn().response.contentAsString

        val item = objectMapper.readValue<UserResponse>(body)
        assertThat(item.name).isEqualTo(userRequest.name)
        assertThat(item.surname).isEqualTo(userRequest.surname)
        assertThat(item.email).isEqualTo(userRequest.email)
    }
}