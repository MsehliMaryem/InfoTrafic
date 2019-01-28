package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.entities.Alerte;
import com.ant.technology.infotrafic.entities.TypeStation;
import com.ant.technology.infotrafic.repositories.AlerteRepository;

import com.ant.technology.infotrafic.services.AlerteService;
import com.ant.technology.infotrafic.services.dto.StringResponse;

@Service
public class AlerteServiceImpl implements AlerteService {
	@Autowired
	private AlerteRepository alerteRepository;

	@Override
	public StringResponse save(Alerte alerte) {
		// TODO Auto-generated method stub
		List<Alerte> list = alerteRepository.findByIdAlerte(alerte.getIdAlerte());

		if (!list.isEmpty()) {
			return new StringResponse(false, "alerte déja existe");
		}

		alerteRepository.save(alerte);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(Alerte alerte) {
		List<Alerte> list = alerteRepository.findByIdAlerte(alerte.getIdAlerte());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Aucune modification detecté");
		}

		list = alerteRepository.findByIdAlerte(alerte.getIdAlerte());
		if (!list.isEmpty()) {
			return new StringResponse(false, "alerte déja existe");
		}

		alerteRepository.save(alerte);
		

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse delete(long code) {
		List<Alerte> list = alerteRepository.findBySignalAlertesIsNotNull();
		if (!list.isEmpty()) {
			return new StringResponse(false, "alerte associé a un ou plusieur signal");
		}

		alerteRepository.delete(code);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Alerte> findAll() {
		return alerteRepository.findAll();

	}

}
