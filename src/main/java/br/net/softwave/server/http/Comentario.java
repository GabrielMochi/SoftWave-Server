package br.net.softwave.server.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comentario {

	private String texto;
	private Postagem postagem;
	private AreaConhecimento areaConhecimento;
	private Usuario usuario;
	
	public Comentario() {
	}

	public Comentario(String texto, Postagem postagem, AreaConhecimento areaConhecimento, Usuario usuario) {
		this.texto = texto;
		this.postagem = postagem;
		this.areaConhecimento = areaConhecimento;
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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
		return "Comentario [texto=" + texto + ", postagem=" + postagem + ", areaConhecimento=" + areaConhecimento
				+ ", usuario=" + usuario + "]";
	}
	
}
