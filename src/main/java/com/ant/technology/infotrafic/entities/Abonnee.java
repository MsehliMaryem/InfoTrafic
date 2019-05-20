package com.ant.technology.infotrafic.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Abonnee extends Personne implements Serializable {

	@JsonIgnore
	@OneToMany(mappedBy = "abonne")
	private List<DemandeTaxi> demandeTaxis;
	

	public List<DemandeTaxi> getDemandeTaxis() {
		return demandeTaxis;
	}

	public void setDemandeTaxis(List<DemandeTaxi> demandeTaxis) {
		this.demandeTaxis = demandeTaxis;
	}


}
