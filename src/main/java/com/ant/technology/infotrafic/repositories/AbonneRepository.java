package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.entities.TypeStation;

public interface AbonneRepository extends JpaRepository<Abonnee, Long> {
	
public List<Abonnee> findByNom(String nom);
public List<Abonnee> findByNomAndId(String nom ,long id);
public List<Abonnee> findById(long id);
public List<Abonnee> findBySignalAlertesIsNotNull();
}
