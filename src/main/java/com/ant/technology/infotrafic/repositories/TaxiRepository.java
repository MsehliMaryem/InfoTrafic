package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Taxi;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {
public List<Taxi> findByMatricule(String matricule);
public List<Taxi> findByNumTaxi (Long numTaxi);
public List<Taxi> findByNumTaxiAndMatricule(Long numTaxi,String matricule);


}
