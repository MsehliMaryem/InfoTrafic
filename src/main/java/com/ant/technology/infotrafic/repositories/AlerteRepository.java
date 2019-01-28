package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Alerte;

public interface AlerteRepository extends JpaRepository<Alerte, Long> {
public List<Alerte> findByIdAlerte(long id);
public List <Alerte> findBySignalAlertesIsNotNull();

}
