package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.entities.Admin;
import com.ant.technology.infotrafic.entities.ChauffeurTaxi;
import com.ant.technology.infotrafic.repositories.ChauffeurRepository;
import com.ant.technology.infotrafic.services.ChauffeurTaxiService;
import com.ant.technology.infotrafic.services.dto.StringResponse;

@Service
public class ChauffeurTaxiServiceImpl implements ChauffeurTaxiService {
@Autowired
private ChauffeurRepository chauffeurRepository ;

@Override
public StringResponse save(ChauffeurTaxi chauffeurTaxi) {
	List<ChauffeurTaxi> list = chauffeurRepository.findByNumPermis(chauffeurTaxi.getNumPermis());

	if (!list.isEmpty()) {
		return new StringResponse(false, "chauffeur taxi déja existe");
	}

	chauffeurRepository.save(chauffeurTaxi);

	return new StringResponse(true, "Opération effectuée avec succès");
	
}

@Override
public StringResponse update(ChauffeurTaxi chauffeurTaxi) {
	List<ChauffeurTaxi> list = chauffeurRepository.findByNumPermis(chauffeurTaxi.getNumPermis());
	if (!list.isEmpty()) {
		return new StringResponse(false, "Aucune modification n'est detectée");
	}

	list =chauffeurRepository.findByNumPermis(chauffeurTaxi.getNumPermis());
	if (!list.isEmpty()) {
		return new StringResponse(false, "chauffeur taxi déja existe");
	}

	chauffeurRepository.save(chauffeurTaxi);
	

	return new StringResponse(true, "Opération effectuée avec succès");
}

@Override
public StringResponse delete(long code) {
	List<ChauffeurTaxi> list = chauffeurRepository.findByNumPermis(code);

	if (list.isEmpty()) {
		return new StringResponse(false, "Chauffeur introuvable ");
	}
	chauffeurRepository.delete(code);

	return new StringResponse(true, "Opération effectuée avec succès");
}

@Override
public List<ChauffeurTaxi> findAll() {
	return chauffeurRepository.findAll();}

}
