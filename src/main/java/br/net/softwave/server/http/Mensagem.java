package br.net.softwave.server.http;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

import br.net.softwave.server.entity.UsuarioEntity;

@XmlRootElement
public class Mensagem {
	
	private String texto;
	private LocalDateTime dataEnvio;
	private boolean recebida;
	private UsuarioEntity transmissor;
	private UsuarioEntity receptor;
	
	public Mensagem() {
	}
	
	public Mensagem(String texto, LocalDateTime dataEnvio, boolean recebida, UsuarioEntity transmissor,
			UsuarioEntity receptor) {
		super();
		this.texto = texto;
		this.dataEnvio = dataEnvio;
		this.recebida = recebida;
		this.transmissor = transmissor;
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

	public UsuarioEntity getTransmissor() {
		return transmissor;
	}

	public void setTransmissor(UsuarioEntity transmissor) {
		this.transmissor = transmissor;
	}

	public UsuarioEntity getReceptor() {
		return receptor;
	}

	public void setReceptor(UsuarioEntity receptor) {
		this.receptor = receptor;
	}
	
}
