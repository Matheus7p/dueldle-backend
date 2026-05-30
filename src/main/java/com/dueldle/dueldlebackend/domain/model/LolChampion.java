package com.dueldle.dueldlebackend.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "tb_lol_champion")
public class LolChampion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "champion_id")
    private String championId;

    @Column(name = "champion_name", nullable = false)
    private String championName;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Set<String> roles;

    @Column(nullable = false)
    private Set<String> species;

    @Column(nullable = false)
    private String resource;

    @Column(nullable = false)
    private String range;

    @Column(nullable = false)
    private Set<String> regions;

    @Column(name = "release_date", nullable = false)
    private Integer releaseDate;

    @Column(name = "character_img_url", nullable = false)
    private String characterImgUrl;

}
