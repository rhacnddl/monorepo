package com.gorany.sample

import com.gorany.annotation.IntegrationTest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@IntegrationTest
class SampleExceptionTest {

    @Disabled("예제를 위한 테스트임")
    @Test
    @DisplayName("예외가 발생하는 테스트")
    fun just_run_throw_exception() {

        throw RuntimeException("SAMPLE ERROR")
    }
}
