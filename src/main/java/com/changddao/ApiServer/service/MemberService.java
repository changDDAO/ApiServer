package com.changddao.ApiServer.service;

import com.changddao.ApiServer.entity.Member;
import com.changddao.ApiServer.repository.MemberRepository;
import com.changddao.ApiServer.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public Long join(Member member) {
        Member saved = memberRepository.save(member);
        return saved.getId();
    }

    public void update(Long id, String name) {
        Member findMember = memberRepository.findById(id).orElse(null);
        findMember.changeName(name);
    }
    public Member findMember(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        return member;
    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}
