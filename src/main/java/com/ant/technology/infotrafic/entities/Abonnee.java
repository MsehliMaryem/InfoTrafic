package com.ant.technology.infotrafic.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Abonnee extends Personne implements Serializable {
	@OneToMany(mappedBy = "abonne")
	private List<DemandeTaxi> demandeTaxis;
	
	
	@OneToMany(mappedBy = "abonne")
	private List<Alerte> alertes;

	@OneToMany(mappedBy="abonne")
	private List<SignalAlerte> signalAlertes;
	
	public List<Alerte> getAlertes() {
		return alertes;
	}

	public void setAlertes(List<Alerte> alertes) {
		this.alertes = alertes;
	}

	public List<DemandeTaxi> getDemandeTaxis() {
		return demandeTaxis;
	}

	public void setDemandeTaxis(List<DemandeTaxi> demandeTaxis) {
		this.demandeTaxis = demandeTaxis;
	}

	public List<SignalAlerte> getSignalAlertes() {
		return signalAlertes;
	}

	public void setSignalAlertes(List<SignalAlerte> signalAlertes) {
		this.signalAlertes = signalAlertes;
	}

	
	
}
