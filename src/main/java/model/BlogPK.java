package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the blog database table.
 * 
 */
@Embeddable
public class BlogPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="postagem_id", insertable=false, updatable=false)
	private int postagemId;

	@Column(insertable=false, updatable=false)
	private int postagem_areaConhecimento_id;

	@Column(name="postagem_usuario_prontuario", insertable=false, updatable=false)
	private String postagemUsuarioProntuario;

	public BlogPK() {
	}
	public int getPostagemId() {
		return this.postagemId;
	}
	public void setPostagemId(int postagemId) {
		this.postagemId = postagemId;
	}
	public int getPostagem_areaConhecimento_id() {
		return this.postagem_areaConhecimento_id;
	}
	public void setPostagem_areaConhecimento_id(int postagem_areaConhecimento_id) {
		this.postagem_areaConhecimento_id = postagem_areaConhecimento_id;
	}
	public String getPostagemUsuarioProntuario() {
		return this.postagemUsuarioProntuario;
	}
	public void setPostagemUsuarioProntuario(String postagemUsuarioProntuario) {
		this.postagemUsuarioProntuario = postagemUsuarioProntuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BlogPK)) {
			return false;
		}
		BlogPK castOther = (BlogPK)other;
		return 
			(this.postagemId == castOther.postagemId)
			&& (this.postagem_areaConhecimento_id == castOther.postagem_areaConhecimento_id)
			&& this.postagemUsuarioProntuario.equals(castOther.postagemUsuarioProntuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.postagemId;
		hash = hash * prime + this.postagem_areaConhecimento_id;
		hash = hash * prime + this.postagemUsuarioProntuario.hashCode();
		
		return hash;
	}
}