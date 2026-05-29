package com.dueldle.dueldlebackend.api.dto.input;

import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public record LolChampionBulkInput(
        String champion_name,
        String gender,
        Set<String> roles,
        Set<String> species,
        String resource,
        String range,
        Set<String> regions,
        Integer release_date,
        String character_img_url,

        @Size(min = 1, max = 10, message = "Maximum 10 champions")
        List<LolChampionInput> champions
) {}
