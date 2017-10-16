package br.net.softwave.server.http;

import java.util.List;

public class AreaConhecimento {

	private int id;
	private String nome;
	private List<Postagem> postagens;
	private List<Atividade> atividades;
	
	public AreaConhecimento() {
	}

	public AreaConhecimento(String nome, List<Postagem> postagens, List<Atividade> atividades) {
		this.nome = nome;
		this.postagens = postagens;
		this.atividades = atividades;
	}

	public AreaConhecimento(int id, String nome, List<Postagem> postagens, List<Atividade> atividades) {
		this.id = id;
		this.nome = nome;
		this.postagens = postagens;
		this.atividades = atividades;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	@Override
	public String toString() {
		return "AreaConhecimento [id=" + id + ", nome=" + nome + ", postagens=" + postagens + ", atividades="
				+ atividades + "]";
	}
	
}
