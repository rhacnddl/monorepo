package com.gorany.service.impl

import com.gorany.dto.RequestMemberSignup
import com.gorany.repository.MemberRepository
import com.gorany.service.MemberService
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(
    val memberRepository: MemberRepository
    ): MemberService {

    override fun getMembers() = memberRepository.getMembers()

    override fun signup(requestMemberSignup: RequestMemberSignup) = memberRepository.save(requestMemberSignup.of()).id

}