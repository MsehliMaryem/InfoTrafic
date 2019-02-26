package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.TypeAlerte;

public interface TypeAlerteService {
	public StringResponse save(TypeAlerte typeAlerte);

	public StringResponse update(TypeAlerte typeAlerte);

	public StringResponse delete(long code);

	public List<TypeAlerte> findAll();
}
