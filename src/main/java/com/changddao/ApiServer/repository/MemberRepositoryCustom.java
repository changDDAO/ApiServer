package com.changddao.ApiServer.repository;

import com.changddao.ApiServer.entity.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom {
    public List<MemberTeamDto> getMemberTeamDto();
}
