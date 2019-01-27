package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.TypeStation;

public interface TypeStationRepository extends JpaRepository<TypeStation, Long> {

	public List<TypeStation> findByNomType(String nomType);

	public List<TypeStation> findByNomTypeAndCode(String nomType, long code);
	
	public List<TypeStation> findByStationServicesIsNotNull();
}
