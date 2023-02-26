package com.gorany.user

import com.gorany.user.repository.UserRepository
import com.gorany.user.request.CreateUserCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = false)
class UserCreateService(
    private val userRepository: UserRepository,
) {

    fun createUser(command: CreateUserCommand) {

        val (email, password, name) = command

        userRepository.findByEmail(email)?.let {
            throw DuplicatedEmailException("${email}은 중복된 이메일 계정입니다.")
        }

        val user = User.of(email, password, name)

        userRepository.save(user)
    }
}
