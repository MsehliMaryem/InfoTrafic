package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.StationService;

public interface StationServiceRepository extends JpaRepository<StationService, Long> {
public List<StationService> findByCode(long code);
public List<StationService> findByNom(String nom);
}
