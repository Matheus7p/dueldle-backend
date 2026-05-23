package com.duldle.dueldlebackend.domain.model;

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
    private String champion_id;

    @Column(nullable = false)
    private String champion_name;

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

    @Column(nullable = false)
    private Integer release_date;

    @Column(nullable = false)
    private String character_img_url;

}
