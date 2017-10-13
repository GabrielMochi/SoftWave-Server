package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MensagemEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "mensageiro", nullable = false, insertable = false, updatable = false)
	private String mensageiro;
	
	@Column(name = "receptor", nullable = false, insertable = false, updatable = false)
	private String receptor;
	
	public MensagemEntityPK() {
	}

	public String getMensageiro() {
		return mensageiro;
	}

	public void setMensageiro(String mensageiro) {
		this.mensageiro = mensageiro;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mensageiro == null) ? 0 : mensageiro.hashCode());
		result = prime * result + ((receptor == null) ? 0 : receptor.hashCode());
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
		MensagemEntityPK other = (MensagemEntityPK) obj;
		if (mensageiro == null) {
			if (other.mensageiro != null)
				return false;
		} else if (!mensageiro.equals(other.mensageiro))
			return false;
		if (receptor == null) {
			if (other.receptor != null)
				return false;
		} else if (!receptor.equals(other.receptor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MensagemPK [mensageiro=" + mensageiro + ", receptor=" + receptor + "]";
	}
	
}
