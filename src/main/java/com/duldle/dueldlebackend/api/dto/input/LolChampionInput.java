package com.duldle.dueldlebackend.api.dto.input;

import java.util.Set;

public record LolChampionInput(
        String champion_name,
        String gender,
        Set<String> roles,
        Set<String> species,
        String resource,
        String range,
        Set<String> regions,
        Integer release_date,
        String character_img_url
) {}
