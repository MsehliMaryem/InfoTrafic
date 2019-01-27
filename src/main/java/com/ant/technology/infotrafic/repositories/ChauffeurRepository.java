package com.ant.technology.infotrafic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.ChauffeurTaxi;

public interface ChauffeurRepository extends JpaRepository<ChauffeurTaxi, Long> {

}
