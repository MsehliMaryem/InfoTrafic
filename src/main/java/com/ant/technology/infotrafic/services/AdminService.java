package com.ant.technology.infotrafic.services;

import java.util.List;


import com.ant.technology.infotrafic.entities.Admin;
import com.ant.technology.infotrafic.services.dto.StringResponse;

public interface AdminService {
	public StringResponse save(Admin admin);

	public StringResponse update(Admin admin);

	public StringResponse delete(long code);

	public List<Admin> findAll();
}
