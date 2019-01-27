package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.entities.TypeStation;
import com.ant.technology.infotrafic.services.dto.StringResponse;

public interface TypeStationService {

	public StringResponse save(TypeStation typeStatation);

	public StringResponse update(TypeStation typeStatation);

	public StringResponse delete(long code);

	public List<TypeStation> findAll();
}
