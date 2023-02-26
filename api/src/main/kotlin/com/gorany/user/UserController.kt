package com.gorany.user

import com.gorany.user.request.CreateUserRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userCreateService: UserCreateService,
) {

    @PostMapping("/api/v1/users/create")
    fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<*> {
        userCreateService.createUser(request.toCommand())

        return ResponseEntity.ok("success")
    }
}
