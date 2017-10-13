package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class QuestaoEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "atividade_id", nullable = false, insertable = false, updatable = false)
	private Integer atividade_id;
	
	@Column(name = "atividade_areaConhecimento_id", nullable = false, insertable = false, updatable = false)
	private Integer atividade_areaConhecimento_id;
	
	public QuestaoEntityPK() {	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAtividade_id() {
		return atividade_id;
	}

	public void setAtividade_id(Integer atividade_id) {
		this.atividade_id = atividade_id;
	}

	public Integer getAtividade_areaConhecimento_id() {
		return atividade_areaConhecimento_id;
	}

	public void setAtividade_areaConhecimento_id(Integer atividade_areaConhecimento_id) {
		this.atividade_areaConhecimento_id = atividade_areaConhecimento_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atividade_areaConhecimento_id == null) ? 0 : atividade_areaConhecimento_id.hashCode());
		result = prime * result + ((atividade_id == null) ? 0 : atividade_id.hashCode());
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
		QuestaoEntityPK other = (QuestaoEntityPK) obj;
		if (atividade_areaConhecimento_id == null) {
			if (other.atividade_areaConhecimento_id != null)
				return false;
		} else if (!atividade_areaConhecimento_id.equals(other.atividade_areaConhecimento_id))
			return false;
		if (atividade_id == null) {
			if (other.atividade_id != null)
				return false;
		} else if (!atividade_id.equals(other.atividade_id))
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
		return "QuestaoEntityPK [id=" + id + ", atividade_id=" + atividade_id + ", atividade_areaConhecimento_id="
				+ atividade_areaConhecimento_id + "]";
	}
	
}
