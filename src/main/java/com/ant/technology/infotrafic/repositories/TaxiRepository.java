package com.ant.technology.infotrafic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Taxi;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {

}
