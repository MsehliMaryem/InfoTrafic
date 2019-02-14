package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.NumeroUrgence;
import com.ant.technology.infotrafic.entities.StationService;
import com.ant.technology.infotrafic.repositories.NumeroUrgenceRepository;
import com.ant.technology.infotrafic.repositories.StationServiceRepository;
import com.ant.technology.infotrafic.services.StationServiceService;
@Service
public class StationServiceServiceImpl implements StationServiceService{
	@Autowired
	private StationServiceRepository stationServiceRepository;
	@Override
	public StringResponse save(StationService stationService) {
		List<StationService> list = stationServiceRepository.findByCode(stationService.getCode());

		if (!list.isEmpty()) {
			return new StringResponse(false, "Station service déja existe");
		}

		stationServiceRepository.save(stationService);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(StationService stationService) {
		List<StationService> list = stationServiceRepository.findByCode(stationService.getCode());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Aucune modification detecté");
		}

		list = stationServiceRepository.findByNom(stationService.getNom());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Station service déja existe");
		}
		stationServiceRepository.save(stationService);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse delete(long code) {
		// TODO Auto-generated method stub
		List<StationService> list = stationServiceRepository.findByCode(code);

		if (list.isEmpty()) {
			return new StringResponse(false, "Station service introuvable ");
		}
		stationServiceRepository.delete(code);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<StationService> findAll() {
		// TODO Auto-generated method stub
		return stationServiceRepository.findAll();
	}

}
