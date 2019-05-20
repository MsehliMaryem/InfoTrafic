package com.ant.technology.infotrafic.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SignalAlerteId implements Serializable{
	@Column(name = "id_personne")
	private long idPersonne;
	@Column(name = "id_alerte")
	private long idAlerte;
	public long getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}
	public long getIdAlerte() {
		return idAlerte;
	}
	public void setIdAlerte(long idAlerte) {
		this.idAlerte = idAlerte;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idAlerte ^ (idAlerte >>> 32));
		result = prime * result + (int) (idPersonne ^ (idPersonne >>> 32));
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
		if (idAlerte != other.idAlerte)
			return false;
		if (idPersonne != other.idPersonne)
			return false;
		return true;
	}
	
	
	
	
}
