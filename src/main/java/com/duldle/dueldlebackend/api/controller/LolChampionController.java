package com.duldle.dueldlebackend.api.controller;

import com.duldle.dueldlebackend.api.dto.LolChampionDTO;
import com.duldle.dueldlebackend.api.dto.input.LolChampionInput;
import com.duldle.dueldlebackend.domain.model.LolChampion;
import com.duldle.dueldlebackend.domain.service.LolChampionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/lol")
@RequiredArgsConstructor
public class LolChampionController {
    private final LolChampionService championService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LolChampion> findAll(){
        return championService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LolChampionDTO createChampion(@RequestBody LolChampionInput championInputData) {
        return championService.create(championInputData);
    }
}
