package com.gorany.annotation

import org.junit.jupiter.api.Tag
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Tag("integrationTest")
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class IntegrationTest()
