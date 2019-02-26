package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ant.technology.infotrafic.entities.TypeAlerte;


public interface TypeAlerteRepository extends JpaRepository<TypeAlerte, Long>{
	public List<TypeAlerte> findByNom(String nom);

	public List<TypeAlerte> findByNomAndIdType(String nom, long code);
	@Query("select t from TypeAlerte t where t.idType=:x and t.alertes IS NOT EMPTY ")
	public List<TypeAlerte> findAlerteAffecter(@Param("x") long id);
	

}
