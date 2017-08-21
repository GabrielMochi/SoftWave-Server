package br.net.softwave.server.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credenciais {
	
	private String prontuario;
	private String senha;
	
	public Credenciais() {
	}
	
	public Credenciais(String prontuario, String senha) {
		this.prontuario = prontuario;
		this.senha = senha;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
