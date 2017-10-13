package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the postagem database table.
 * 
 */
@Embeddable
public class PostagemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(insertable=false, updatable=false)
	private int areaConhecimento_id;

	@Column(name="usuario_prontuario", insertable=false, updatable=false)
	private String usuarioProntuario;

	public PostagemPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAreaConhecimento_id() {
		return this.areaConhecimento_id;
	}
	public void setAreaConhecimento_id(int areaConhecimento_id) {
		this.areaConhecimento_id = areaConhecimento_id;
	}
	public String getUsuarioProntuario() {
		return this.usuarioProntuario;
	}
	public void setUsuarioProntuario(String usuarioProntuario) {
		this.usuarioProntuario = usuarioProntuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PostagemPK)) {
			return false;
		}
		PostagemPK castOther = (PostagemPK)other;
		return 
			(this.id == castOther.id)
			&& (this.areaConhecimento_id == castOther.areaConhecimento_id)
			&& this.usuarioProntuario.equals(castOther.usuarioProntuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.areaConhecimento_id;
		hash = hash * prime + this.usuarioProntuario.hashCode();
		
		return hash;
	}
}