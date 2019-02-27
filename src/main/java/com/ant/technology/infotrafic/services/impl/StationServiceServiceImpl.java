package com.ant.technology.infotrafic.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.StationService;
import com.ant.technology.infotrafic.repositories.StationServiceRepository;
import com.ant.technology.infotrafic.services.StationServiceService;
@Service
public class StationServiceServiceImpl implements StationServiceService{
	

	@Autowired
	private StationServiceRepository stationServiceRepository;
	@Override
	public StringResponse save(StationService stationService) {
	

		stationServiceRepository.save(stationService);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(StationService stationService) {
		
		
	
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
