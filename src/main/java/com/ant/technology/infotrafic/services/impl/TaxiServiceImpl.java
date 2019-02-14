package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Taxi;
import com.ant.technology.infotrafic.repositories.TaxiRepository;
import com.ant.technology.infotrafic.services.TaxiService;

public class TaxiServiceImpl implements TaxiService {
	@Autowired
	private TaxiRepository taxiRepository ;
	@Override
	public StringResponse save(Taxi taxi) {
		List<Taxi>  list= taxiRepository.findByNumTaxi(taxi.getNumTaxi());
		if (!list.isEmpty()) {
			return new StringResponse(false, "taxi déja existe");
		}
		taxiRepository.save(taxi);
		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(Taxi taxi) {
		List<Taxi>  list= taxiRepository.findByNumTaxiAndMatricule(taxi.getNumTaxi(),taxi.getMatricule());
		if (!list.isEmpty()) {
			return new StringResponse(false, "taxi déja existe");
		}
		taxiRepository.save(taxi);
		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse delete(Long numtaxi) {
		List<Taxi>  list= taxiRepository.findByNumTaxi(numtaxi);
		if (list.isEmpty()) {
			return new StringResponse(false, "taxi introuvable");
		}
		taxiRepository.delete(numtaxi);
		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Taxi> findAll() {
		return taxiRepository.findAll();
		
	}
	

}
