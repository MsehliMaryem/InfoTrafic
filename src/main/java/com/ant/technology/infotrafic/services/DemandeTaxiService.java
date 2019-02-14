package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.DemandeTaxi;

public interface DemandeTaxiService {
	public StringResponse save(DemandeTaxi demandeTaxi);

	public StringResponse update(DemandeTaxi demandeTaxi);

	public StringResponse delete(long code);

	public List<DemandeTaxi> findAll();
}
