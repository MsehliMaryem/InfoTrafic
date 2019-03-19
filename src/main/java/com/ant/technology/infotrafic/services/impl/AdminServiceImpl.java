package com.ant.technology.infotrafic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.dto.StringResponseAdmin;
import com.ant.technology.infotrafic.entities.Admin;
import com.ant.technology.infotrafic.repositories.AdminRepository;
import com.ant.technology.infotrafic.services.AdminService;
import com.ant.technology.infotrafic.utils.CodeGenerator;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public StringResponse save(Admin admin) {

		List<Admin> list = adminRepository.findByLogin(admin.getLogin());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Nom d'utilisateur déja existe");
		}
		list = adminRepository.findByMatricule(admin.getMatricule());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Matricule déja existe");
		}

		list = adminRepository.findByEmail(admin.getEmail());
		if (!list.isEmpty()) {
			return new StringResponse(false, "Email déja existe");
		}
		String pwd = CodeGenerator.generatedCode();
		String password = bCryptPasswordEncoder.encode(pwd);
		admin.setPassword(password);
		admin.setEnabled(true);
		adminRepository.save(admin);

		return new StringResponseAdmin(true, "Opération effectuée avec succès", admin.getLogin(), pwd,
				admin.getEmail());
	}

	@Override
	public StringResponse update(Admin admin) {

		List<Admin> list = adminRepository.findByLoginAndId(admin.getLogin(), admin.getId());
		if (list.isEmpty()) {
			list = adminRepository.findByLogin(admin.getLogin());
			if (!list.isEmpty()) {
				return new StringResponse(false, "Nom d'utilisateur déja existe");
			}
		}

		list = adminRepository.findByEmailAndId(admin.getEmail(), admin.getId());
		if (list.isEmpty()) {
			list = adminRepository.findByEmail(admin.getEmail());
			if (!list.isEmpty()) {
				return new StringResponse(false, "Email déja existe");
			}
		}

		list = adminRepository.findByMatriculeAndId(admin.getMatricule(), admin.getId());
		if (list.isEmpty()) {
			list = adminRepository.findByMatricule(admin.getMatricule());
			if (!list.isEmpty()) {
				return new StringResponse(false, "Matricule déja existe");
			}
		}

		Admin admin1 = adminRepository.findOne(admin.getId());
		if (admin.equals(admin1)) {
			return new StringResponse(false, "Aucune modification detectée");
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
