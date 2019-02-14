package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.ChauffeurTaxi;

public interface ChauffeurTaxiService {
	public StringResponse save(ChauffeurTaxi chauffeurTaxi);

	public StringResponse update(ChauffeurTaxi chauffeurTaxi);

	public StringResponse activer(long id,String code);

	public StringResponse desactiver(long code);


	public List<ChauffeurTaxi> findAll();
}
