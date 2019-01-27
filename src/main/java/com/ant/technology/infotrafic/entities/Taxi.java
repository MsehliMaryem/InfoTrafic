package com.ant.technology.infotrafic.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Taxi implements Serializable {

	@Id
	private String matricule;
	@Column(unique = true, name = "num_taxi")
	private long numTaxi;
	private String marque;
	private String modele;
	private int nbplace;
	private boolean disponibilite;
	@OneToMany(mappedBy = "taxi")
	private List<ChauffeurTaxi> chauffeurTaxis;

	@OneToMany(mappedBy = "taxi")
private List<DemandeTaxi> demandeTaxis ;
	public List<DemandeTaxi> getDemandeTaxis() {
		return demandeTaxis;
	}

	public void setDemandeTaxis(List<DemandeTaxi> demandeTaxis) {
		this.demandeTaxis = demandeTaxis;
	}

	public List<ChauffeurTaxi> getChauffeurTaxis() {
		return chauffeurTaxis;
	}

	public void setChauffeurTaxis(List<ChauffeurTaxi> chauffeurTaxis) {
		this.chauffeurTaxis = chauffeurTaxis;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public long getNumTaxi() {
		return numTaxi;
	}

	public void setNumTaxi(long numTaxi) {
		this.numTaxi = numTaxi;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getNbplace() {
		return nbplace;
	}

	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	public Taxi() {
		super();
	}

}
