package com.duldle.dueldlebackend.api.dto_mapper;

import com.duldle.dueldlebackend.api.dto.LolChampionDTO;
import com.duldle.dueldlebackend.api.dto.input.LolChampionInput;
import com.duldle.dueldlebackend.domain.model.LolChampion;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = ALWAYS,
        nullValuePropertyMappingStrategy = IGNORE
)
public interface LolChampionMapper {
    LolChampionDTO fromEntity(final LolChampion entity);
    LolChampion fromDTO(final LolChampionInput dto);
}
