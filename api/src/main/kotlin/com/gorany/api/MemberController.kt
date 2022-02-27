package com.gorany.api

import com.gorany.dto.RequestMemberSignup
import com.gorany.entity.Member
import com.gorany.service.MemberService
import com.gorany.util.LoggerDelegate
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/members")
@Slf4j
class MemberController(
    private val memberService: MemberService,
) {
    private val log by LoggerDelegate()

    @GetMapping(value = ["" ,"/"])
    fun getMembers(): List<Member> {
        log.info("getMembers Call")

        return memberService.getMembers()
    }

    @PostMapping("/signup")
    fun signup(requestMemberSignup: RequestMemberSignup): Long {
        log.info("Signup Call")

        return memberService.signup(requestMemberSignup)
    }
}