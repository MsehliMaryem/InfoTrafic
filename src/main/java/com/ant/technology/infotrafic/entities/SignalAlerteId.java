package com.ant.technology.infotrafic.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SignalAlerteId implements Serializable{
	@Column(name = "id_abonne")
	private long idAbonne;
	@Column(name = "id_alerte")
	private long idAlerte;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idAbonne ^ (idAbonne >>> 32));
		result = prime * result + (int) (idAlerte ^ (idAlerte >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignalAlerteId other = (SignalAlerteId) obj;
		if (idAbonne != other.idAbonne)
			return false;
		if (idAlerte != other.idAlerte)
			return false;
		return true;
	}
	public long getIdAbonne() {
		return idAbonne;
	}
	public void setIdAbonne(long idAbonne) {
		this.idAbonne = idAbonne;
	}
	public long getIdAlerte() {
		return idAlerte;
	}
	public void setIdAlerte(long idAlerte) {
		this.idAlerte = idAlerte;
	}

	
	
	
}
