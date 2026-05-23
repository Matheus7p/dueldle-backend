package com.duldle.dueldlebackend.domain.repository;

import com.duldle.dueldlebackend.domain.model.LolChampion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LolChampionRepository extends JpaRepository<LolChampion, String> {
}
