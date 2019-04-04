package com.ant.technology.infotrafic.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Alerte;
import com.ant.technology.infotrafic.repositories.AlerteRepository;

import com.ant.technology.infotrafic.services.AlerteService;

@Service
public class AlerteServiceImpl implements AlerteService {
	@Autowired
	private AlerteRepository alerteRepository;

	@Override
	public StringResponse save(Alerte alerte) {

		alerte.setDateAlerte(new Date());
		alerte.setEnabled(true);
		alerteRepository.save(alerte);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(Alerte alerte) {

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

	@Override
	public StringResponse activate(Alerte alerte) {
		alerteRepository.save(alerte);
		if (alerte.isEnabled()) {
			return new StringResponse(true, "Aelerte desactivée avec succès");
		}
		return new StringResponse(true, "Aelerte activée avec succès");
	}

}
