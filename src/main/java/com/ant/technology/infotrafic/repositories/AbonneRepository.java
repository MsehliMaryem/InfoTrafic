package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Abonnee;

public interface AbonneRepository extends JpaRepository<Abonnee, Long> {


public List<Abonnee> findByEmail(String email);
public List<Abonnee> findByLogin(String login);
public List<Abonnee> findByEmailAndId(String email ,long id);
public List<Abonnee> findByLoginAndId(String login ,long id);



}
