package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.NumeroUrgence;

public interface NumeroUrgenceRepository extends JpaRepository<NumeroUrgence, Long> {
	public List<NumeroUrgence> findByNum(long num);
	public List<NumeroUrgence> findByNumAndLibelle(long num,String libelle);
	

}
