package com.dueldle.dueldlebackend.api.dto_mapper;

import com.dueldle.dueldlebackend.api.dto.LolChampionDTO;
import com.dueldle.dueldlebackend.api.dto.input.LolChampionInput;
import com.dueldle.dueldlebackend.domain.model.LolChampion;
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
