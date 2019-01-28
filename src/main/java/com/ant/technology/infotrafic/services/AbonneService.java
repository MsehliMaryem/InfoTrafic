package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.entities.TypeStation;
import com.ant.technology.infotrafic.services.dto.StringResponse;

public interface AbonneService {
	

		public StringResponse save(Abonnee abonnee);

		public StringResponse update(Abonnee abonnee);

		public StringResponse delete(long code);

		public List<Abonnee> findAll();
	}

