package com.simhero.hello.service;

import com.simhero.hello.domain.Member;
import com.simhero.hello.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void tearDown() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long id = memberService.join(member);

        // then
        Member member1 = memberService.findById(id).get();
        assertThat(member.getName()).isEqualTo(member1.getName());
    }

    @Test
    void 중복회원테스트() {
        Member member = new Member();
        member.setName("hello");
        memberService.join(member);
        Member member2 = new Member();
        member2.setName("hello");
        IllegalStateException e = assertThrows(IllegalStateException.class, () ->memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findById() {
    }
}