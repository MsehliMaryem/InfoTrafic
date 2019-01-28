package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.entities.Abonnee;
import com.ant.technology.infotrafic.entities.Admin;
import com.ant.technology.infotrafic.entities.TypeStation;
import com.ant.technology.infotrafic.repositories.AdminRepository;
import com.ant.technology.infotrafic.repositories.TypeStationRepository;
import com.ant.technology.infotrafic.services.AdminService;
import com.ant.technology.infotrafic.services.dto.StringResponse;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepository adminRepository;
	@Override
	public StringResponse save(Admin admin) {
		List<Admin> list = adminRepository.findByNom(admin.getNom());

		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom admin déja existe");
		}

		adminRepository.save(admin);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse update(Admin admin) {
		List<Admin> list = adminRepository.findByIdAndNom(admin.getId(), admin.getNom());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Aucune modification n'est detectée");
		}

		list = adminRepository.findByNom(admin.getNom());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom type station déja existe");
		}

		adminRepository.save(admin);
		

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public StringResponse delete(long id) {
		List<Admin> list = adminRepository.findById(id);

		if (list.isEmpty()) {
			return new StringResponse(false, "Admin introuvable ");
		}
		adminRepository.delete(id);

		return new StringResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

}
