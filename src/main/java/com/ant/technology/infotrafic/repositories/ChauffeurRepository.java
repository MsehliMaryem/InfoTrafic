package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ant.technology.infotrafic.entities.ChauffeurTaxi;

public interface ChauffeurRepository extends JpaRepository<ChauffeurTaxi, Long> {

public List<ChauffeurTaxi> findByEmail(String email);
public List<ChauffeurTaxi> findByLogin(String login);
public List<ChauffeurTaxi> findByEmailAndId(String email ,long id);
public List<ChauffeurTaxi> findByLoginAndId(String login ,long id);


}
