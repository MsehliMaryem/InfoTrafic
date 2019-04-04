package com.ant.technology.infotrafic.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Alerte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAlerte;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_alerte")
	private Date dateAlerte;
	private boolean enabled;
	@ManyToOne
	@JoinColumn(name = "id_abonnee", nullable = false)
	private Abonnee abonne;

	@ManyToOne
	@JoinColumn(name = "id_admin", nullable = true)
	private Admin admin;
	
	@OneToMany(mappedBy = "alerte")
	private List<SignalAlerte> signalAlertes;

	@ManyToOne
	@JoinColumn(name = "id_type_alerte")
	private TypeAlerte typeAlerte;

	public long getIdAlerte() {
		return idAlerte;
	}

	public void setIdAlerte(long idAlerte) {
		this.idAlerte = idAlerte;
	}

	public TypeAlerte getTypeAlerte() {
		return typeAlerte;
	}

	public void setTypeAlerte(TypeAlerte typeAlerte) {
		this.typeAlerte = typeAlerte;
	}

	public Abonnee getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonnee abonne) {
		this.abonne = abonne;
	}

	public List<SignalAlerte> getSignalAlertes() {
		return signalAlertes;
	}

	public void setSignalAlertes(List<SignalAlerte> signalAlertes) {
		this.signalAlertes = signalAlertes;
	}

	public Date getDateAlerte() {
		return dateAlerte;
	}

	public void setDateAlerte(Date dateAlerte) {
		this.dateAlerte = dateAlerte;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
