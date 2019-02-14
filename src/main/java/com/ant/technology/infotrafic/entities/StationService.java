package com.ant.technology.infotrafic.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "station_service")
public class StationService implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	private String nom;
	private double longitude;
	private double latitude;
	@ManyToOne
	@JoinColumn(name = "id_type_station")
	private TypeStation typeStation;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double lattitude) {
		this.latitude = lattitude;
	}

	public TypeStation getTypeStation() {
		return typeStation;
	}

	public void setTypeStation(TypeStation typeStation) {
		this.typeStation = typeStation;
	}

	

}
