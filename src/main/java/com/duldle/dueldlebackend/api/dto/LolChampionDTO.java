package com.duldle.dueldlebackend.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LolChampionDTO {
    private String champion_id;
    private String champion_name;
    private String gender;
    private Set<String> roles;
    private Set<String> species;
    private String resource;
    private String range;
    private Set<String> regions;
    private Integer release_date;
    private String character_img_url;

}
