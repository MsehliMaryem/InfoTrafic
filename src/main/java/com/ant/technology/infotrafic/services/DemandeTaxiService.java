package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.entities.DemandeTaxi;
import com.ant.technology.infotrafic.services.dto.StringResponse;

public interface DemandeTaxiService {
	public StringResponse save(DemandeTaxi demandeTaxi);

	public StringResponse update(DemandeTaxi demandeTaxi);

	public StringResponse delete(long code);

	public List<DemandeTaxi> findAll();
}
