package com.ant.technology.infotrafic.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ant.technology.infotrafic.dto.StringResponse;

import com.ant.technology.infotrafic.entities.StationService;

public interface StationServiceService {
	public StringResponse save(StationService stationService);

	public StringResponse update(StationService stationService);

	public StringResponse delete(long code);

	public List<StationService> findAll();

}
