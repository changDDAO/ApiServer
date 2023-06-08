package com.changddao.ApiServer.repository;

import com.changddao.ApiServer.entity.Member;
import com.changddao.ApiServer.entity.Team;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;

    @Test
    public void 멤버_crud(){
        Team team1 = new Team("teamA");
        Team team2 = new Team("teamB");
        teamRepository.save(team1);
        teamRepository.save(team2);


    //given
    Member member1 = new Member("changho");
    Member member2 = new Member("jongho");
    Member member3 = new Member("jina");
    Member member4 = new Member("seok");

    member1.setTeam(team1);
    member2.setTeam(team1);
    member3.setTeam(team2);
    member4.setTeam(team2);
    memberRepository.save(member1);
    memberRepository.save(member2);
    memberRepository.save(member3);
    memberRepository.save(member4);


        List<Member> all = memberRepository.findAll();
        for (Member member : all) {
            System.out.println("member.team "+member.getTeam().getTeamName());
        }
    }


        //then


}