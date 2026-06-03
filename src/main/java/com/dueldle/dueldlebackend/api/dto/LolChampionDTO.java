package com.dueldle.dueldlebackend.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LolChampionDTO {
    private String championId;
    private String championName;
    private String gender;
    private Set<String> roles;
    private Set<String> species;
    private String resource;
    private String range;
    private Set<String> regions;
    private Integer releaseDate;
    private String characterImgUrl;
}
