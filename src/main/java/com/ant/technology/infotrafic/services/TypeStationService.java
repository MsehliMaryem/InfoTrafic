package com.ant.technology.infotrafic.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.TypeStation;

public interface TypeStationService {

	public StringResponse save(TypeStation typeStatation);

	public StringResponse update(TypeStation typeStatation);

	public StringResponse delete(long code);

	public List<TypeStation> findAll();
	public void store(MultipartFile file) ;
}
