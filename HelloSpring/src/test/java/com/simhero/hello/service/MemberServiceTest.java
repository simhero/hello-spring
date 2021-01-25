package com.simhero.hello.service;

import com.simhero.hello.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@SpringBootTest
public class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    public void join() {
        // given
        Member member = new Member();
        member.setName("hello2");

        log.info("member {}",member);
        // when
        Long id = memberService.join(member);
        log.info("member {}",member);

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
