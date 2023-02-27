package com.gorany.annotation

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
@Tag("unitTest")
@Retention(AnnotationRetention.RUNTIME)
annotation class UnitTest()
