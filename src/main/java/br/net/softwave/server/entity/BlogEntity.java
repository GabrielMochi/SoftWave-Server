package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class BlogEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BlogEntityPK blogEntityPK;	
	
	@OneToOne
	@JoinColumns({ 
		@JoinColumn(name = "postagem_id", referencedColumnName = "id", nullable = false),
		@JoinColumn(name = "postagem_areaConhecimento_id", referencedColumnName = "areaConhecimento_id", nullable = false),
		@JoinColumn(name = "postagem_usuario_prontuario", referencedColumnName = "usuario_prontuario", nullable = false)
	})
	private PostagemEntity postagemEntity;
	
	public BlogEntity() {
	}

	public BlogEntityPK getBlogEntityPK() {
		return blogEntityPK;
	}

	public void setBlogEntityPK(BlogEntityPK blogEntityPK) {
		this.blogEntityPK = blogEntityPK;
	}

	public PostagemEntity getPostagemEntity() {
		return postagemEntity;
	}

	public void setPostagemEntity(PostagemEntity postagemEntity) {
		this.postagemEntity = postagemEntity;
	}

	@Override
	public String toString() {
		return "BlogEntity [blogEntityPK=" + blogEntityPK + ", postagemEntity=" + postagemEntity + "]";
	}
	
}
