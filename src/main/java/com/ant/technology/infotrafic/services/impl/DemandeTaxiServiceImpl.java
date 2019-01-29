package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.entities.Admin;
import com.ant.technology.infotrafic.entities.Alerte;
import com.ant.technology.infotrafic.entities.DemandeTaxi;
import com.ant.technology.infotrafic.repositories.DemandeTaxiRepository;
import com.ant.technology.infotrafic.services.DemandeTaxiService;
import com.ant.technology.infotrafic.services.dto.StringResponse;

@Service
public class DemandeTaxiServiceImpl implements DemandeTaxiService {
	@Autowired
	private DemandeTaxiRepository demandeTaxiRepository;
	@Override
	public StringResponse save(DemandeTaxi demandeTaxi) {
		List<DemandeTaxi> list = demandeTaxiRepository.findById(demandeTaxi.getId());

		if (!list.isEmpty()) {
			return new StringResponse(false, "demande taxi déja existe");
		}

		demandeTaxiRepository.save(demandeTaxi);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(DemandeTaxi demandeTaxi) {
		// TODO Auto-generated method stub
		List<DemandeTaxi> list = demandeTaxiRepository.findById(demandeTaxi.getId());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Aucune modification detecté");
		}

		list = demandeTaxiRepository.findById(demandeTaxi.getId());
		if (!list.isEmpty()) {
			return new StringResponse(false, "demande taxi déja existe");
		}

		demandeTaxiRepository.save(demandeTaxi);
		

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse delete(long code) {
		// TODO Auto-generated method stub
		List<DemandeTaxi> list = demandeTaxiRepository.findById(code);

		if (list.isEmpty()) {
			return new StringResponse(false, "demande taxi introuvable ");
		}
		demandeTaxiRepository.delete(code);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<DemandeTaxi> findAll() {
		// TODO Auto-generated method stub
		return demandeTaxiRepository.findAll();
	}

}
