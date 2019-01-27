package com.ant.technology.infotrafic.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="chauffeur_taxi")
public class ChauffeurTaxi extends Personne implements Serializable {
	@Column(unique = true, name = "num_permis")
	private long numPermis;
	@ManyToOne
	private Taxi taxi;

	public long getNumPermis() {
		return numPermis;
	}

	public void setNumPermis(long numPermis) {
		this.numPermis = numPermis;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	

}
