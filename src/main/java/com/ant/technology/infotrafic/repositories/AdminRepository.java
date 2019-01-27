package com.ant.technology.infotrafic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.technology.infotrafic.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin ,Long> {

}
