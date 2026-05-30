package com.dueldle.dueldlebackend.domain.exception;

import java.util.List;

public class LolChampionAlreadyExistsException extends RuntimeException {
    public LolChampionAlreadyExistsException(String championName) {
        super("Champion " + championName + " already exists.");
    }

    public LolChampionAlreadyExistsException(List<String> championsNames) {
        super("Champions already exist: " + String.join(", ", championsNames));
    }
}
