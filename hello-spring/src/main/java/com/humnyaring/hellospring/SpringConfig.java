package com.humnyaring.hellospring;

import com.humnyaring.hellospring.repository.MemberRepository;
import com.humnyaring.hellospring.repository.MemoryMemberRepository;
import com.humnyaring.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
