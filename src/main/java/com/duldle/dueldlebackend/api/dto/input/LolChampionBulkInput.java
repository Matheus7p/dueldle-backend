package com.duldle.dueldlebackend.api.dto.input;

import jakarta.validation.constraints.Size;
import org.hibernate.annotations.BatchSize;

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

        @Size(min = 1, max = 10, message = "Maximo de 10 campeoes")
        List<LolChampionInput> champions
) {}
