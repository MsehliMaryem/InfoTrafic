package com.ant.technology.infotrafic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

	public Personne findByLogin(String login);
	public Personne findByEmail(String email);
	public Personne findByEmailAndCode(String email, String code);

}
