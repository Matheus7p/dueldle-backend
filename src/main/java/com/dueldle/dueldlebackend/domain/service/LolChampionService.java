package com.dueldle.dueldlebackend.domain.service;

import com.dueldle.dueldlebackend.api.dto.LolChampionDTO;
import com.dueldle.dueldlebackend.api.dto.input.LolChampionBulkInput;
import com.dueldle.dueldlebackend.api.dto.input.LolChampionInput;
import com.dueldle.dueldlebackend.api.dto_mapper.LolChampionMapper;
import com.dueldle.dueldlebackend.domain.exception.LolChampionAlreadyExistsException;
import com.dueldle.dueldlebackend.domain.model.LolChampion;
import com.dueldle.dueldlebackend.domain.repository.LolChampionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LolChampionService {

    private final LolChampionRepository lolChampionRepository;
    private final LolChampionMapper mapper;


    @Cacheable("champions")
    public List<LolChampion> findAll(){
        System.out.println(">> BUSCANDO NO BANCO");
        return lolChampionRepository.findAll();
    }


    @Transactional
    @CacheEvict(value = "champions", allEntries = true)
    public LolChampionDTO create(LolChampionInput championInputData){
        if (lolChampionRepository.existsByChampionName(championInputData.championName())) {
            throw new LolChampionAlreadyExistsException(championInputData.championName());
        }

        LolChampion lolChampionModel = mapper.toEntity(championInputData);
        return mapper.toDTO(lolChampionRepository.save(lolChampionModel));
    }

    @Transactional
    @CacheEvict(value = "champions", allEntries = true)
    public List<LolChampion> createBulking(LolChampionBulkInput championInputData){
        List<String> existingNames = championInputData.champions()
                .stream()
                .map(LolChampionInput::championName)
                .filter(lolChampionRepository::existsByChampionName)
                .toList();

        if(!existingNames.isEmpty()) {
            throw new LolChampionAlreadyExistsException(existingNames);
        }

        List<LolChampion> champions = championInputData.champions()
                .stream()
                .map(dto -> {
                    return mapper.toEntity(dto);
                }).toList();
        return lolChampionRepository.saveAll(champions);
    }
}
