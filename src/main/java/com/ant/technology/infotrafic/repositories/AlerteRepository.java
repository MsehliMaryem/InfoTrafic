package com.ant.technology.infotrafic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Alerte;

public interface AlerteRepository extends JpaRepository<Alerte, Long> {

}
