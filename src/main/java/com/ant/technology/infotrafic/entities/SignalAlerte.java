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

@Entity
@Table(name = "signal_alerte")
public class SignalAlerte {
	@EmbeddedId
	private SignalAlerteId id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_signal")
	private Date dateSignal;

	@ManyToOne
	@JoinColumn(name = "id_alerte", insertable = false, updatable = false, nullable = false)
	private Alerte alerte;
	@ManyToOne
	@JoinColumn(name = "id_abonne", insertable = false, updatable = false, nullable = false)
	private Abonnee abonne;
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
	public Abonnee getAbonne() {
		return abonne;
	}
	public void setAbonne(Abonnee abonne) {
		this.abonne = abonne;
	}

	
	
}
