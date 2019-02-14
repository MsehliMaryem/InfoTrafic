package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.entities.TypeStation;

public interface AbonneService {

	public StringResponse save(Abonnee abonnee);

	public StringResponse update(Abonnee abonnee);

	public StringResponse activer(long id,String code);

	public StringResponse desactiver(long code);

	public List<Abonnee> findAll();
}
