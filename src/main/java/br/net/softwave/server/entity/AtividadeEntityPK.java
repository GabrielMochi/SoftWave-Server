package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class AtividadeEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "areaConhecimento_id", nullable = false, insertable = false, updatable = false)
	private Integer areaConhecimento_id;
	
	public AtividadeEntityPK() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAreaConhecimento_id() {
		return areaConhecimento_id;
	}

	public void setAreaConhecimento_id(Integer areaConhecimento_id) {
		this.areaConhecimento_id = areaConhecimento_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaConhecimento_id == null) ? 0 : areaConhecimento_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AtividadeEntityPK other = (AtividadeEntityPK) obj;
		if (areaConhecimento_id == null) {
			if (other.areaConhecimento_id != null)
				return false;
		} else if (!areaConhecimento_id.equals(other.areaConhecimento_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtividadeEntityPK [id=" + id + ", areaConhecimento_id=" + areaConhecimento_id + "]";
	}
	
}
