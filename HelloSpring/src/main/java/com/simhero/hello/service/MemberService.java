package com.simhero.hello.service;

import com.simhero.hello.domain.Member;
import com.simhero.hello.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDupicatMember(member);
        log.info("member = {}", member);
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDupicatMember(Member member) {
        log.info("member2 = {}", member);

        Optional<Member> result = memberRepository.findByName(member.getName());
        log.info("member2 = {}", member);

        result.ifPresent(member1 -> {
            log.info("member3 = {}", member);

            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
