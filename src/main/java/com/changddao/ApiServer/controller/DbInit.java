package com.changddao.ApiServer.controller;

import com.changddao.ApiServer.entity.Info;
import com.changddao.ApiServer.entity.Member;
import com.changddao.ApiServer.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbInit {
    private final MemberService memberService;
    @PostConstruct
    public void init() {
        Member member = new Member("changho", new Info("010-5057-8352","대구 수성구 황금동"));
        Member member1 = new Member("jongho", new Info("010-8771-8352","대구 수성구 황금동"));
        Member member2 = new Member("jina", new Info("010-9859-8448","대구 수성구 황금동"));
        Member member3 = new Member("seok", new Info("010-7942-0000","대구 수성구 황금동"));
        memberService.join(member);
        memberService.join(member1);
        memberService.join(member2);
        memberService.join(member3);

    }
}
