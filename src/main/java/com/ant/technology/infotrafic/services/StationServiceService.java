package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.entities.ChauffeurTaxi;
import com.ant.technology.infotrafic.entities.StationService;
import com.ant.technology.infotrafic.services.dto.StringResponse;

public interface StationServiceService {
	public StringResponse save(StationService stationService);

	public StringResponse update(StationService stationService);

	public StringResponse delete(long code);

	public List<StationService> findAll();
}
