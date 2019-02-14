package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.DemandeTaxi;
import com.ant.technology.infotrafic.entities.NumeroUrgence;
import com.ant.technology.infotrafic.repositories.DemandeTaxiRepository;
import com.ant.technology.infotrafic.repositories.NumeroUrgenceRepository;
import com.ant.technology.infotrafic.services.NumeroUrgenceService;
@Service
public class NumeroUrgenceServiceImpl implements NumeroUrgenceService {
	@Autowired
	private NumeroUrgenceRepository numeroUrgenceRepository;
	@Override
	public StringResponse save(NumeroUrgence numeroUrgence) {
		List<NumeroUrgence> list = numeroUrgenceRepository.findByNum(numeroUrgence.getNum());

		if (!list.isEmpty()) {
			return new StringResponse(false, "Numero d'urgence déja existe");
		}

		numeroUrgenceRepository.save(numeroUrgence);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(NumeroUrgence numeroUrgence) {
		

		List<NumeroUrgence>  list = numeroUrgenceRepository.findByNum(numeroUrgence.getNum());
		if (!list.isEmpty()) {
			return new StringResponse(false, "numero d'urgence déja existe");
		}
		numeroUrgenceRepository.save(numeroUrgence);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse delete(long code) {
		// TODO Auto-generated method stub
		List<NumeroUrgence> list = numeroUrgenceRepository.findByNum(code);

		if (list.isEmpty()) {
			return new StringResponse(false, "Numero d'urgence introuvable ");
		}
		numeroUrgenceRepository.delete(code);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<NumeroUrgence> findAll() {
		// TODO Auto-generated method stub
		return numeroUrgenceRepository.findAll();
	}

}
