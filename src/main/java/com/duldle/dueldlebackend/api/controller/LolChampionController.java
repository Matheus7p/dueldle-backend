package com.duldle.dueldlebackend.api.controller;

import com.duldle.dueldlebackend.api.dto.LolChampionDTO;
import com.duldle.dueldlebackend.api.dto.input.LolChampionBulkInput;
import com.duldle.dueldlebackend.api.dto.input.LolChampionInput;
import com.duldle.dueldlebackend.domain.model.LolChampion;
import com.duldle.dueldlebackend.domain.service.LolChampionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
