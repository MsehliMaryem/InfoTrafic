package com.ant.technology.infotrafic.services;

import java.util.List;


import com.ant.technology.infotrafic.entities.Alerte;
import com.ant.technology.infotrafic.services.dto.StringResponse;

public interface AlerteService {
	public StringResponse save(Alerte alerte);

	public StringResponse update(Alerte alerte);

	public StringResponse delete(long code);

	public List<Alerte> findAll();

}
