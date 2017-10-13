package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the mensagem database table.
 * 
 */
@Embeddable
public class MensagemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String mensageiro;

	@Column(insertable=false, updatable=false)
	private String receptor;

	public MensagemPK() {
	}
	public String getMensageiro() {
		return this.mensageiro;
	}
	public void setMensageiro(String mensageiro) {
		this.mensageiro = mensageiro;
	}
	public String getReceptor() {
		return this.receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MensagemPK)) {
			return false;
		}
		MensagemPK castOther = (MensagemPK)other;
		return 
			this.mensageiro.equals(castOther.mensageiro)
			&& this.receptor.equals(castOther.receptor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mensageiro.hashCode();
		hash = hash * prime + this.receptor.hashCode();
		
		return hash;
	}
}