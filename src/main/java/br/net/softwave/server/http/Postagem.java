package br.net.softwave.server.http;

public class Postagem {

	private int id;
	private Usuario usuario;
	private AreaConhecimento areaConhecimento;
	private boolean visivel;
	
	public Postagem() {
	}

	public Postagem(Usuario usuario, AreaConhecimento areaConhecimento, boolean visivel) {
		this.usuario = usuario;
		this.areaConhecimento = areaConhecimento;
		this.visivel = visivel;
	}

	public Postagem(int id, Usuario usuario, AreaConhecimento areaConhecimento, boolean visivel) {
		this.id = id;
		this.usuario = usuario;
		this.areaConhecimento = areaConhecimento;
		this.visivel = visivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	@Override
	public String toString() {
		return "Postagem [id=" + id + ", usuario=" + usuario + ", areaConhecimento=" + areaConhecimento + ", visivel="
				+ visivel + "]";
	}

}
