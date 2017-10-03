package br.net.softwave.server.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AreaConhecimento {

	private int id;
	private String nome;
	private String corDeFundo;
	
	public AreaConhecimento() {
	}
	
	public AreaConhecimento(String nome, String corDeFundo) {
		this.nome = nome;
		this.corDeFundo = corDeFundo;
	}
	
	public AreaConhecimento(int id, String nome, String corDeFundo) {	
		this.id = id;
		this.nome = nome;
		this.corDeFundo = corDeFundo;
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

	public String getCorDeFundo() {
		return corDeFundo;
	}

	public void setCorDeFundo(String corDeFundo) {
		this.corDeFundo = corDeFundo;
	}
	
}
