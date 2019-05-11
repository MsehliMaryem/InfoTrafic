package com.ant.technology.infotrafic.services;

import com.ant.technology.infotrafic.dto.PasswordDTO;
import com.ant.technology.infotrafic.dto.StringResponse;
import com.ant.technology.infotrafic.entities.Personne;

public interface PersonneService {
	public StringResponse checkPassword(PasswordDTO pwdDto);
	public StringResponse changePassword(PasswordDTO pwdDto);

	public StringResponse activate(Personne personne);
	public StringResponse ForgotPassword(String email);
	public StringResponse changeForgotPassword(PasswordDTO pwdDto);
	public StringResponse checkCode(String email, String code);
}
