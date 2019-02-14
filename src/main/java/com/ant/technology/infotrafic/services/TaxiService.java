package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Taxi;



public interface TaxiService {
	public StringResponse save(Taxi taxi);
	public StringResponse update(Taxi taxi);
	public StringResponse delete(Long numtaxi);
	public List<Taxi> findAll();

}
