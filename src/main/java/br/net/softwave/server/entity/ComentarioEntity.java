package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class ComentarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComentarioEntityPK ComentarioEntityPK;	
	
	@Column(name = "texto", nullable = false)
	private String texto;
	
	@OneToOne(optional = false)
	@JoinColumns({ 
		@JoinColumn(name = "postagem_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false),
		@JoinColumn(name = "postagem_areaConhecimento_id", referencedColumnName = "areaConhecimento_id", nullable = false, 
					insertable = false, updatable = false),
		@JoinColumn(name = "postagem_usuario_prontuario", referencedColumnName = "usuario_prontuario", nullable = false, 
					insertable = false, updatable = false)
	})
	private PostagemEntity postagemEntity;
	
	public ComentarioEntity() {
	}

	public ComentarioEntityPK getComentarioEntityPK() {
		return ComentarioEntityPK;
	}

	public void setComentarioEntityPK(ComentarioEntityPK comentarioEntityPK) {
		this.ComentarioEntityPK = comentarioEntityPK;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public PostagemEntity getPostagemEntity() {
		return postagemEntity;
	}

	public void setPostagemEntity(PostagemEntity postagemEntity) {
		this.postagemEntity = postagemEntity;
	}

	@Override
	public String toString() {
		return "ComentarioEntity [ComentarioEntityPK=" + ComentarioEntityPK + ", texto=" + texto + ", postagemEntity="
				+ postagemEntity + "]";
	}

}