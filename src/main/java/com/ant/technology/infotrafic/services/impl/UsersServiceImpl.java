package com.ant.technology.infotrafic.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.dto.StringResponseAdmin;
import com.ant.technology.infotrafic.entities.Personne;
import com.ant.technology.infotrafic.repositories.PersonneRepository;
import com.ant.technology.infotrafic.services.UsersService;
import com.ant.technology.infotrafic.utils.CodeGenerator;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		
		Personne pers = personneRepository.findByLogin(username);
		
		if(pers!=null) {
			return pers;
		}
		
		return null;
	}

}
	


