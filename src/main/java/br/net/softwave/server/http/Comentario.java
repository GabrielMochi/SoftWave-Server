package br.net.softwave.server.http;

public class Comentario {
	
	private Postagem postagem;
	private String texto;
	
	public Comentario() {
	}

	public Comentario(Postagem postagem, String texto) {
		this.postagem = postagem;
		this.texto = texto;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Comentario [postagem=" + postagem + ", texto=" + texto + "]";
	}
	
}
