package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class BlogEntityPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "postagem_id", nullable = false, insertable = false, updatable = false)
	private Integer postagem_id;

	@Column(name = "postagem_areaConhecimento_id", nullable = false, insertable = false, updatable = false)
	private Integer postagem_areaConhecimento_id;

	@Column(name = "postagem_usuario_prontuario", nullable = false, insertable = false, updatable = false)
	@Size(min = 7, max = 7)
	private Integer postagem_usuario_prontuario;

	public BlogEntityPK() {
	}

	public Integer getPostagem_id() {
		return postagem_id;
	}

	public void setPostagem_id(Integer postagem_id) {
		this.postagem_id = postagem_id;
	}

	public Integer getPostagem_areaConhecimento_id() {
		return postagem_areaConhecimento_id;
	}

	public void setPostagem_areaConhecimento_id(Integer postagem_areaConhecimento_id) {
		this.postagem_areaConhecimento_id = postagem_areaConhecimento_id;
	}

	public Integer getPostagem_usuario_prontuario() {
		return postagem_usuario_prontuario;
	}

	public void setPostagem_usuario_prontuario(Integer postagem_usuario_prontuario) {
		this.postagem_usuario_prontuario = postagem_usuario_prontuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((postagem_areaConhecimento_id == null) ? 0 : postagem_areaConhecimento_id.hashCode());
		result = prime * result + ((postagem_id == null) ? 0 : postagem_id.hashCode());
		result = prime * result + ((postagem_usuario_prontuario == null) ? 0 : postagem_usuario_prontuario.hashCode());
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
		BlogEntityPK other = (BlogEntityPK) obj;
		if (postagem_areaConhecimento_id == null) {
			if (other.postagem_areaConhecimento_id != null)
				return false;
		} else if (!postagem_areaConhecimento_id.equals(other.postagem_areaConhecimento_id))
			return false;
		if (postagem_id == null) {
			if (other.postagem_id != null)
				return false;
		} else if (!postagem_id.equals(other.postagem_id))
			return false;
		if (postagem_usuario_prontuario == null) {
			if (other.postagem_usuario_prontuario != null)
				return false;
		} else if (!postagem_usuario_prontuario.equals(other.postagem_usuario_prontuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BlogEntityPK [postagem_id=" + postagem_id + ", postagem_areaConhecimento_id="
				+ postagem_areaConhecimento_id + ", postagem_usuario_prontuario=" + postagem_usuario_prontuario + "]";
	}

}
