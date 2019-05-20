package com.ant.technology.infotrafic.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Personne implements Serializable, UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String login;
	private String password;
	private String code;

	private boolean enabled;
	private boolean activation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "personne")
	private List<Alerte> alertes;
	@JsonIgnore
	@OneToMany(mappedBy = "personne")
	private List<SignalAlerte> signalAlertes;

	public List<Alerte> getAlertes() {
		return alertes;
	}

	public void setAlertes(List<Alerte> alertes) {
		this.alertes = alertes;
	}
	public List<SignalAlerte> getSignalAlertes() {
		return signalAlertes;
	}

	public void setSignalAlertes(List<SignalAlerte> signalAlertes) {
		this.signalAlertes = signalAlertes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Personne() {
		super();
	}

	public boolean isEnabled() {
		
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@JsonIgnore
	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authorities = new ArrayList<>();

		if (this instanceof Admin) {
			if (((Admin) this).isSuperAdmin()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_SuperAdmin"));
			} else {
				authorities.add(new SimpleGrantedAuthority("ROLE_Admin"));
			}
		}
		if (this instanceof Abonnee) {
			authorities.add(new SimpleGrantedAuthority("ROLE_Abonnee"));
		}
		if (this instanceof ChauffeurTaxi) {
			authorities.add(new SimpleGrantedAuthority("ROLE_Chauffeur"));
		}

		return authorities;
	}

	@JsonIgnore
	@Transient
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@JsonIgnore
	@Transient
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Transient
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isActivation() {
		return activation;
	}

	public void setActivation(boolean activation) {
		this.activation = activation;
	}

}
