package com.dueldle.dueldlebackend.api.controller;

import com.dueldle.dueldlebackend.api.dto.LolChampionDTO;
import com.dueldle.dueldlebackend.api.dto.input.LolChampionBulkInput;
import com.dueldle.dueldlebackend.api.dto.input.LolChampionInput;
import com.dueldle.dueldlebackend.domain.model.LolChampion;
import com.dueldle.dueldlebackend.domain.service.LolChampionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/lol")
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

    @PostMapping("/bulk-insert")
    @ResponseStatus(HttpStatus.CREATED)
    public List<LolChampion> createBulk(@RequestBody @Valid LolChampionBulkInput championInputData) {
        return championService.createBulking(championInputData);
    }
}
