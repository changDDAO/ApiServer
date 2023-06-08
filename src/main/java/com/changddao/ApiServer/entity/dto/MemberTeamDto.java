package com.changddao.ApiServer.entity.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberTeamDto {
    private String username;
    private String teamName;
    private Long teamId;
    @QueryProjection
    public MemberTeamDto(String username, String teamName, Long teamId) {
        this.username = username;
        this.teamName = teamName;
        this.teamId = teamId;
    }
}
