package com.dueldle.dueldlebackend.api.dto.input;

import java.util.Set;

public record LolChampionInput(
        String championName,
        String gender,
        Set<String> roles,
        Set<String> species,
        String resource,
        String range,
        Set<String> regions,
        Integer releaseDate,
        String characterImgUrl
) {}
