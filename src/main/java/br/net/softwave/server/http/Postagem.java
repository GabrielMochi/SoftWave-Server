package br.net.softwave.server.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Postagem {

	private int id;
	private boolean visivel;
	private AreaConhecimento areaConhecimento;
	private Usuario usuario;
	
	public Postagem() {
	}

	public Postagem(boolean visivel, AreaConhecimento areaConhecimento, Usuario usuario) {
		this.visivel = visivel;
		this.areaConhecimento = areaConhecimento;
		this.usuario = usuario;
	}
	
	public Postagem(int id, boolean visivel, AreaConhecimento areaConhecimento, Usuario usuario) {
		this.id = id;
		this.visivel = visivel;
		this.areaConhecimento = areaConhecimento;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
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
		return "Postagem [id=" + id + ", visivel=" + visivel + ", areaConhecimento=" + areaConhecimento + ", usuario="
				+ usuario + "]";
	}
	
}
