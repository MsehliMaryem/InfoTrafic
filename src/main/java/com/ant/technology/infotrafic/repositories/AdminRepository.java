package com.ant.technology.infotrafic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin ,Long> {
	public List<Admin> findByNom(String nom);
	public List<Admin>findById(long Id);
	public List<Admin>findByIdAndNom(long Id,String nom);

}
