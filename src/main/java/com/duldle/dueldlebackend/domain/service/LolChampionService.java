package com.duldle.dueldlebackend.domain.service;

import com.duldle.dueldlebackend.api.dto.LolChampionDTO;
import com.duldle.dueldlebackend.api.dto.input.LolChampionInput;
import com.duldle.dueldlebackend.api.dto_mapper.LolChampionMapper;
import com.duldle.dueldlebackend.domain.model.LolChampion;
import com.duldle.dueldlebackend.domain.repository.LolChampionRepository;
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
        LolChampion lolChampionModel = mapper.fromDTO(championInputData);
        return mapper.fromEntity(lolChampionRepository.save(lolChampionModel));
    }
}
