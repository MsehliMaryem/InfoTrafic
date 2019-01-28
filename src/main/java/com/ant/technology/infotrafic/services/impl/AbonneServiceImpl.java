package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.entities.Alerte;
import com.ant.technology.infotrafic.entities.TypeStation;
import com.ant.technology.infotrafic.repositories.AbonneRepository;
import com.ant.technology.infotrafic.repositories.TypeStationRepository;
import com.ant.technology.infotrafic.services.AbonneService;
import com.ant.technology.infotrafic.services.dto.StringResponse;
@Service
public class AbonneServiceImpl implements AbonneService {
	@Autowired
	private AbonneRepository abonneRepository;

	@Override
	public StringResponse save(Abonnee abonnee) {
		// TODO Auto-generated method stub
		List<Abonnee> list = abonneRepository.findByNom(abonnee.getNom());

		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom abonnee déja existe");
		}

		abonneRepository.save(abonnee);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(Abonnee abonnee) {
		List<Abonnee> list = abonneRepository.findByNomAndId(abonnee.getNom(), abonnee.getId());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Aucune modification detecté");
		}

		list = abonneRepository.findByNom(abonnee.getNom());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom abonneé déja existe");
		}

		abonneRepository.save(abonnee);
		

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse delete(long code) {
		List<Abonnee> list = abonneRepository.findBySignalAlertesIsNotNull();
		if (!list.isEmpty()) {
			return new StringResponse(false, "abonnee associé a un ou plusieur signal");
		}
		if (list.isEmpty()) {
			return new StringResponse(false, "Abonnée introuvable ");
		}
		abonneRepository.delete(code);

		return new StringResponse(true, "Opération effectuée avec succès");
	
	}

	@Override
	public List<Abonnee> findAll() {
		
		return abonneRepository.findAll();
	}

}
