package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Alerte;

public interface AlerteService {
	public StringResponse save(Alerte alerte);

	public StringResponse update(Alerte alerte);

	public StringResponse delete(long code);
	public StringResponse activate(Alerte alerte);
	public List<Alerte> findAll();
	public List<Alerte> findEnableAlerte();
	public List<Alerte> findByTypeAlerteIdTypeIn(List<Long> ids);
}
