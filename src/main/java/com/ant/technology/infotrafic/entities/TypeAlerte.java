package com.ant.technology.infotrafic.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type_alerte")
public class TypeAlerte implements Serializable {
	@Id
	@Column(name = "id_type")
	private long idType;
	@Column(unique = true)
	private String nom;
	@OneToMany(mappedBy = "typeAlerte")
	private List<Alerte> alertes;

	public long getIdType() {
		return idType;
	}

	public void setIdType(long idType) {
		this.idType = idType;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Alerte> getAlertes() {
		return alertes;
	}

	public void setAlertes(List<Alerte> alertes) {
		this.alertes = alertes;
	}
}
