package com.changddao.ApiServer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Team extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    Long id;
    private String teamName;
    @OneToMany(mappedBy = "team")
    private List<Member> members=new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }
}
