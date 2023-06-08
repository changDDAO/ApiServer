package com.changddao.ApiServer.repository;

import com.changddao.ApiServer.entity.dto.MemberTeamDto;
import com.changddao.ApiServer.entity.dto.QMemberTeamDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.changddao.ApiServer.entity.QMember.*;
import static com.changddao.ApiServer.entity.QTeam.*;

public class MemberRepositoryImpl implements MemberRepositoryCustom{
    JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<MemberTeamDto> getMemberTeamDto() {
        List<MemberTeamDto> result = queryFactory.select(new QMemberTeamDto(member.username, team.teamName, team.id))
                .from(member)
                .leftJoin(member.team, team)
                .fetch();
        return result;
    }
}
