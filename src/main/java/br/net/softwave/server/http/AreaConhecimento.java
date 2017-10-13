package br.net.softwave.server.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AreaConhecimento {

	private int id;
	private String nome;
	
	public AreaConhecimento() {
	}
	
	public AreaConhecimento(String nome) {
		this.nome = nome;
	}
	
	public AreaConhecimento(int id, String nome) {	
		this.id = id;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "AreaConhecimento [id=" + id + ", nome=" + nome + "]";
	}
	
}
