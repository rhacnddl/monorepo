package com.gorany.user

import com.gorany.annotation.UnitTest
import org.apache.commons.lang3.StringUtils
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@UnitTest
internal class UserTest {

    @Test
    @DisplayName("계정 생성시 패스워드는 8자 이상이어야한다.")
    fun when_create_user_then_password_length_must_longer_than_eight() {

        //given
        val email = StringUtils.EMPTY
        val name = StringUtils.EMPTY
        val password = "0123456789"
        
        //when
        val result = User.of(email, password, name)

        //then
        assertThat(result.password.length).isGreaterThanOrEqualTo(8)
    }

    @Test
    @DisplayName("계정 생성시 패스워드가 8자 미만이면 예외가 발생한다.")
    fun throw_exception_when_password_length_is_under_eight() {

        //given
        val email = StringUtils.EMPTY
        val name = StringUtils.EMPTY
        val password = "0"

        //when
        assertThatThrownBy { User.of(email, password, name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("비밀번호는 8자 이상이어야 합니다.")
    }
}
