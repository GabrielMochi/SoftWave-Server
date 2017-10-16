package br.net.softwave.server.http;

public class Forum {

	private Postagem postagem;
	private String texto;
	
	public Forum() {
	}

	public Forum(Postagem postagem, String texto) {
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
		return "Forum [postagem=" + postagem + ", texto=" + texto + "]";
	}
	
}
