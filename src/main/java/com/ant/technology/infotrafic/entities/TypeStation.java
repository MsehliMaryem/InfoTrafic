package com.ant.technology.infotrafic.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "type_station")
public class TypeStation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code;
	@Column(unique = true, name = "nom_type")
	private String nomType;
	
	private String photo;

	@JsonIgnore
	@OneToMany(mappedBy = "typeStation")
	private List<StationService> stationServices;
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	
	public List<StationService> getStationServices() {
		return stationServices;
	}
	public void setStationServices(List<StationService> stationServices) {
		this.stationServices = stationServices;
	}
	public String getNomType() {
		return nomType;
	}
	public void setNomType(String nomType) {
		this.nomType = nomType;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

	
	
	
}
