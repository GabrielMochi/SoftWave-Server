package br.net.softwave.server.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Table(name = "mensagem")
public class MensagemEntity {

	@Column(name = "texto", nullable = false)
	private String texto;
	
	@Column(name = "dataEnvio", nullable = false)
	private LocalDateTime dataEnvio;
	
	@Column(name = "recebida", nullable = false, columnDefinition = "TINYINT(1)")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean recebida;

	@Column(name = "mensageiro", nullable = false)
	@ManyToOne
	private UsuarioEntity mensageiro;
	
	@Column(name = "receptor", nullable = false)
	@OneToOne
	private UsuarioEntity receptor;

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

	public Boolean getRecebida() {
		return recebida;
	}

	public void setRecebida(Boolean recebida) {
		this.recebida = recebida;
	}

	public UsuarioEntity getMensageiro() {
		return mensageiro;
	}

	public void setMensageiro(UsuarioEntity mensageiro) {
		this.mensageiro = mensageiro;
	}

	public UsuarioEntity getReceptor() {
		return receptor;
	}

	public void setReceptor(UsuarioEntity receptor) {
		this.receptor = receptor;
	}
	
}
