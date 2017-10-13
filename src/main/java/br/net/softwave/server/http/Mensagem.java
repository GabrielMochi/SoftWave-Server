package br.net.softwave.server.http;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mensagem {

	private String texto;
	private LocalDateTime dataEnvio;
	private boolean recebida;
	private Usuario transmissor;
	private Usuario receptor;

	public Mensagem() {
	}

	public Mensagem(String texto, LocalDateTime dataEnvio, boolean recebida, Usuario transmissor, Usuario receptor) {
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

	public Usuario getTransmissor() {
		return transmissor;
	}

	public void setTransmissor(Usuario transmissor) {
		this.transmissor = transmissor;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	@Override
	public String toString() {
		return "Mensagem [texto=" + texto + ", dataEnvio=" + dataEnvio + ", recebida=" + recebida + ", transmissor="
				+ transmissor + ", receptor=" + receptor + "]";
	}

}
