package com.gorany.repository

import com.gorany.config.TestQuerydslConfig
import com.gorany.entity.SampleUser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@DataJpaTest
@Import(TestQuerydslConfig::class)
class SampleUserRepositoryTest @Autowired constructor(
    val sampleUserRepository: SampleUserRepository
) {

    @Test
    @DisplayName("샘플유저 생성 테스트")
    fun create_sample_user() {

        //given
        val name = "sample"
        val age = 15

        val sampleUser = SampleUser(name = name, age = age)
        //when
        val result = sampleUserRepository.save(sampleUser)

        //then
        assertThat(result.id).isGreaterThan(0)
        assertThat(result.name).isEqualTo(name)
    }
}