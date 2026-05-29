package com.dueldle.dueldlebackend.domain.service;

import com.dueldle.dueldlebackend.api.dto.LolChampionDTO;
import com.dueldle.dueldlebackend.api.dto.input.LolChampionBulkInput;
import com.dueldle.dueldlebackend.api.dto.input.LolChampionInput;
import com.dueldle.dueldlebackend.api.dto_mapper.LolChampionMapper;
import com.dueldle.dueldlebackend.domain.model.LolChampion;
import com.dueldle.dueldlebackend.domain.repository.LolChampionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LolChampionService {

    private final LolChampionRepository lolChampionRepository;
    private final LolChampionMapper mapper;


    public List<LolChampion> findAll(){
        return lolChampionRepository.findAll();
    }

    @Transactional
    public LolChampionDTO create(LolChampionInput championInputData){
        LolChampion lolChampionModel = mapper.toEntity(championInputData);
        return mapper.toDTO(lolChampionRepository.save(lolChampionModel));
    }

    @Transactional
    public List<LolChampion> createBulking(LolChampionBulkInput championInputData){
        List<LolChampion> champions = championInputData.champions()
                .stream()
                .map(dto -> {
                    return mapper.toEntity(dto);
                }).toList();
        return lolChampionRepository.saveAll(champions);
    }
}
