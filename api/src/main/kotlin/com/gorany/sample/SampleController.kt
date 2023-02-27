package com.gorany.sample

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {

    @GetMapping("/api/v1/samples/error")
    fun throwException(): ResponseEntity<*> {

        throw RuntimeException("sample 예외가 발생합니다.")
    }
}
