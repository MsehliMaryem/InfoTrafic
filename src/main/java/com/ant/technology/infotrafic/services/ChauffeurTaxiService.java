package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.entities.ChauffeurTaxi;
import com.ant.technology.infotrafic.services.dto.StringResponse;

public interface ChauffeurTaxiService {
	public StringResponse save(ChauffeurTaxi chauffeurTaxi);

	public StringResponse update(ChauffeurTaxi chauffeurTaxi);

	public StringResponse delete(long code);

	public List<ChauffeurTaxi> findAll();
}
