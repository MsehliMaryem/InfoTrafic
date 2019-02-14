package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin ,Long> {
	public List<Admin>  findByLogin(String login);
	public List<Admin> findById(Long id);
	public List<Admin> findByMatricule(String matricule);
	public List<Admin> findByLoginAndMatricule(String login,String matricule);

}
