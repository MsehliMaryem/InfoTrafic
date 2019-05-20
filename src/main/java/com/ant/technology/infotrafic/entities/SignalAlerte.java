package com.ant.technology.infotrafic.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "signal_alerte")
public class SignalAlerte {
	@EmbeddedId
	private SignalAlerteId id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_signal")
	private Date dateSignal;
	private String cause;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_alerte", insertable = false, updatable = false, nullable = false)
	private Alerte alerte;
	@ManyToOne
	@JoinColumn(name = "id_personne", insertable = false, updatable = false, nullable = false)
	private Personne personne;
	public SignalAlerteId getId() {
		return id;
	}
	public void setId(SignalAlerteId id) {
		this.id = id;
	}
	public Date getDateSignal() {
		return dateSignal;
	}
	public void setDateSignal(Date dateSignal) {
		this.dateSignal = dateSignal;
	}
	public Alerte getAlerte() {
		return alerte;
	}
	public void setAlerte(Alerte alerte) {
		this.alerte = alerte;
	}

	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	
	
}
