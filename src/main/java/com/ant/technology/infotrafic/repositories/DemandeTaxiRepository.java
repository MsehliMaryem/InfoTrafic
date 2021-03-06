package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.DemandeTaxi;

public interface DemandeTaxiRepository extends JpaRepository<DemandeTaxi, Long>{
public List<DemandeTaxi> findById(long id);

}
