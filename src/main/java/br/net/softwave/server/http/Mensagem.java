package br.net.softwave.server.http;

import java.time.LocalDateTime;

public class Mensagem {
	
	private Usuario mensageiro;
	private Usuario receptor;
	private String texto;
	private LocalDateTime dataEnvio;
	private boolean recebida;
	
	public Mensagem() {
	}

	public Mensagem(Usuario mensageiro, Usuario receptor, String texto, LocalDateTime dataEnvio, boolean recebida) {
		this.mensageiro = mensageiro;
		this.receptor = receptor;
		this.texto = texto;
		this.dataEnvio = dataEnvio;
		this.recebida = recebida;
	}

	public Usuario getMensageiro() {
		return mensageiro;
	}

	public void setMensageiro(Usuario mensageiro) {
		this.mensageiro = mensageiro;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public boolean isRecebida() {
		return recebida;
	}

	public void setRecebida(boolean recebida) {
		this.recebida = recebida;
	}

	@Override
	public String toString() {
		return "Mensagem [mensageiro=" + mensageiro + ", receptor=" + receptor + ", texto=" + texto + ", dataEnvio="
				+ dataEnvio + ", recebida=" + recebida + "]";
	}
	
}
