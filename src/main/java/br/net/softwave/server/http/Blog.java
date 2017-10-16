package br.net.softwave.server.http;

public class Blog {

	private Postagem postagem;
	
	public Blog() {
	}

	public Blog(Postagem postagem) {
		this.postagem = postagem;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	@Override
	public String toString() {
		return "Blog [postagem=" + postagem + "]";
	}
	
}
