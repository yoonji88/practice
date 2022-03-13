package com.kmong.demo.service;

import java.util.Optional;

import com.kmong.demo.models.Member;
import com.kmong.demo.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    
    public Member save(Member member) {
        memberRepository.save(member);
        return member;
    }

    public Optional<Member> findById(String id) {
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

}
