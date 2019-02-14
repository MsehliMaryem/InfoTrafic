package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ant.technology.infotrafic.entities.TypeStation;

public interface TypeStationRepository extends JpaRepository<TypeStation, Long> {

	public List<TypeStation> findByNomType(String nomType);

	public List<TypeStation> findByNomTypeAndCode(String nomType, long code);

	@Query("select t from TypeStation t where t.code=:x and t.stationServices IS NOT EMPTY ")
	public List<TypeStation> findStationAffecter(@Param("x") long id);
}
