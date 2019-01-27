package com.ant.technology.infotrafic.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="demande_taxi")
public class DemandeTaxi implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private double attitude;
	private double longitude;
	@ManyToOne
	private Abonnee abonne;
	
	@ManyToOne
	private Taxi taxi;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAttitude() {
		return attitude;
	}

	public void setAttitude(double attitude) {
		this.attitude = attitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Abonnee getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonnee abonne) {
		this.abonne = abonne;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	
}
