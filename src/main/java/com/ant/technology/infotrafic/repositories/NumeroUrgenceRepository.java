package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.NumeroUrgence;

public interface NumeroUrgenceRepository extends JpaRepository<NumeroUrgence, Long> {
	public List<NumeroUrgence> findByLibelle(String libelle);
	public List<NumeroUrgence> findById(long id);
	public List<NumeroUrgence> findByNumAndLibelle(long num,String libelle);
	

}
