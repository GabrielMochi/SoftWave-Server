package br.net.softwave.server.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Blog {

	private String enderecoConteudo;
	private Postagem postagem;
	private AreaConhecimento areaConhecimento;
	private Usuario usuario;
	
	public Blog() {
	}

	public Blog(String enderecoConteudo, Postagem postagem, AreaConhecimento areaConhecimento, Usuario usuario) {
		this.enderecoConteudo = enderecoConteudo;
		this.postagem = postagem;
		this.areaConhecimento = areaConhecimento;
		this.usuario = usuario;
	}

	public String getEnderecoConteudo() {
		return enderecoConteudo;
	}

	public void setEnderecoConteudo(String enderecoConteudo) {
		this.enderecoConteudo = enderecoConteudo;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Blog [enderecoConteudo=" + enderecoConteudo + ", postagem=" + postagem + ", areaConhecimento="
				+ areaConhecimento + ", usuario=" + usuario + "]";
	}
	
}
