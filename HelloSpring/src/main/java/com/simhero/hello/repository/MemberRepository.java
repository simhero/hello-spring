package com.simhero.hello.repository;

import com.simhero.hello.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    public Member save(Member member);

    public List<Member> findAll();

    public Optional<Member> findById(Long id);

    public Optional<Member> findByName(String name);
}
