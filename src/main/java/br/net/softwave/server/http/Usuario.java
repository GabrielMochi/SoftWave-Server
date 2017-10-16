package br.net.softwave.server.http;

import java.util.List;

public class Usuario {

	private String prontuario;
	private Permissao permissao;
	private List<Postagem> postagens;
	private List<Mensagem> mensagens;

	public Usuario() {
	}

	public Usuario(Permissao permissao, List<Postagem> postagens, List<Mensagem> mensagens) {
		this.permissao = permissao;
		this.postagens = postagens;
		this.mensagens = mensagens;
	}

	public Usuario(String prontuario, Permissao permissao, List<Postagem> postagens, List<Mensagem> mensagens) {
		this.prontuario = prontuario;
		this.permissao = permissao;
		this.postagens = postagens;
		this.mensagens = mensagens;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public enum Permissao {

		ALUNO("ALUNO"), PROFESSOR("PROFESSOR"), ADMIN("ADMIN");

		private final String valor;

		private Permissao(String valor) {
			this.valor = valor;
		}

		public String getValor() {
			return valor;
		}

	}

	@Override
	public String toString() {
		return "Usuario [prontuario=" + prontuario + ", permissao=" + permissao + ", postagens=" + postagens
				+ ", mensagens=" + mensagens + "]";
	}

}
