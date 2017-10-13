package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

@Embeddable
public class PostagemEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "usuario_prontuario", nullable = false, insertable = false, updatable = false)
	@Size(max = 8)
	private String usuario_prontuario;
	
	@Column(name = "areaConhecimento_id", nullable = false, insertable = false, updatable = false)
	private Integer areaConhecimento_id;
	
	public PostagemEntityPK() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario_prontuario() {
		return usuario_prontuario;
	}

	public void setUsuario_prontuario(String usuario_prontuario) {
		this.usuario_prontuario = usuario_prontuario;
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
		result = prime * result + ((usuario_prontuario == null) ? 0 : usuario_prontuario.hashCode());
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
		PostagemEntityPK other = (PostagemEntityPK) obj;
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
		if (usuario_prontuario == null) {
			if (other.usuario_prontuario != null)
				return false;
		} else if (!usuario_prontuario.equals(other.usuario_prontuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostagemEntityPK [id=" + id + ", usuario_prontuario=" + usuario_prontuario + ", areaConhecimento_id="
				+ areaConhecimento_id + "]";
	}
	
}
