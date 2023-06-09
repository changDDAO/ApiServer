package com.changddao.ApiServer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;
    @NotBlank(message = "유저 네임을 입력해주세요.")
    private String username;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Embedded
    private Info info;

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
    public void changeName(String name) {
        this.username = name;
    }

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, Info info) {
        this.username = username;
        this.info = info;
    }
}
