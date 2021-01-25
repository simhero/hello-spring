package com.simhero.hello.repository;

import com.simhero.hello.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MemoryMemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");
        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {

        Member member1 = new Member();
        member1.setName("spring");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName(member2.getName()).get();
        assertThat(member2).isEqualTo(result);

    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> memberList = memberRepository.findAll();
//        assertThat(memberList.size()).isEqualTo(1);
    }
}
