package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "forum")
public class ForumEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ForumEntityPK forumEntityPK;

	@Lob
	@Column(name = "texto", nullable = false)
	private String texto;

	@OneToOne(optional = false)
	@JoinColumns({ @JoinColumn(name = "postagem_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "postagem_areaConhecimento_id", referencedColumnName = "areaConhecimento_id", nullable = false, 
						insertable = false, updatable = false),
			@JoinColumn(name = "postagem_usuario_prontuario", referencedColumnName = "usuario_prontuario", nullable = false, 
						insertable = false, updatable = false) 
	})
	private PostagemEntity postagemEntity;

	public ForumEntity() {
	}

	public ForumEntityPK getForumEntityPK() {
		return forumEntityPK;
	}

	public void setForumEntityPK(ForumEntityPK forumEntityPK) {
		this.forumEntityPK = forumEntityPK;
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
		return "ForumEntity [forumEntityPK=" + forumEntityPK + ", texto=" + texto + ", postagemEntity=" + postagemEntity
				+ "]";
	}

}
