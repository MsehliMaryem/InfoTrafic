package com.ant.technology.infotrafic.services;

import java.util.List;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Admin;

public interface AdminService {
	public StringResponse save(Admin admin);

	public StringResponse update(Admin admin);

	public StringResponse delete(long code);

	public List<Admin> findAll();
}
