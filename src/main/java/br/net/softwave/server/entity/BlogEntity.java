package br.net.softwave.server.entity;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "blog")
public class BlogEntity extends PostagemEntity {

	@Column(name = "enderecoConteudo", nullable = false)
	private String enderecoConteudo;
	
	@Column(name = "postagem_id", nullable = false)
	@OneToOne
	private PostagemEntity postagemEntity;
	
	@Column(name = "postagem_areaConhecimento_id", nullable = false)
	@OneToOne
	private AreaConhecimentoEntity areaConhecimento;
	
	@Column(name = "postagem_usuario_prontuario", nullable = false)
	@OneToOne
	private UsuarioEntity usuario;

	public String getEnderecoConteudo() {
		return enderecoConteudo;
	}

	public void setEnderecoConteudo(String enderecoConteudo) {
		this.enderecoConteudo = enderecoConteudo;
	}

	public PostagemEntity getPostagemEntity() {
		return postagemEntity;
	}

	public void setPostagemEntity(PostagemEntity postagemEntity) {
		this.postagemEntity = postagemEntity;
	}

	public AreaConhecimentoEntity getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimentoEntity areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
}
