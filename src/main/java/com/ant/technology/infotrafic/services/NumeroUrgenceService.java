package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.entities.NumeroUrgence;
import com.ant.technology.infotrafic.services.dto.StringResponse;

public interface NumeroUrgenceService {
	public StringResponse save(NumeroUrgence numeroUrgence);

	public StringResponse update(NumeroUrgence numeroUrgence);

	public StringResponse delete(long code);

	public List<NumeroUrgence> findAll();
}
