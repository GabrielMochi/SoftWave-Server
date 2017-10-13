package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "postagem")
public class PostagemEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PostagemEntityPK postagemEntityPK;
	
	@Column(name = "visivel", columnDefinition = "TINYINT(1)", nullable = false, insertable = false, updatable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean visivel;
	
	@ManyToOne
	@JoinColumn(name = "usuario_prontuario", referencedColumnName = "prontuario")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name = "areaConhecimento_id", referencedColumnName = "id")
	private AreaConhecimentoEntity areaConhecimento;
	
	public PostagemEntity() {
	}

	public PostagemEntityPK getPostagemEntityPK() {
		return postagemEntityPK;
	}

	public void setPostagemEntityPK(PostagemEntityPK postagemEntityPK) {
		this.postagemEntityPK = postagemEntityPK;
	}

	public Boolean getVisivel() {
		return visivel;
	}

	public void setVisivel(Boolean visivel) {
		this.visivel = visivel;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public AreaConhecimentoEntity getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimentoEntity areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	@Override
	public String toString() {
		return "PostagemEntity [postagemEntityPK=" + postagemEntityPK + ", visivel=" + visivel + ", usuario=" + usuario
				+ "]";
	}
	
}
