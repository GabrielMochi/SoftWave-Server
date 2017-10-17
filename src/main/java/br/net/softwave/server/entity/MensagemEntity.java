package br.net.softwave.server.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "mensagem")
public class MensagemEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MensagemEntityPK mensagemEntityPK;
	
	@Lob
	@Column(name = "texto", nullable = false, insertable = false, updatable = false)
	private String texto;
	
	@Column(name = "dataEnvio", columnDefinition = "DATETIME", nullable = false, insertable = false, updatable = false)
	private LocalDateTime dataEnvio;
	
	@Column(name = "recebida", columnDefinition = "TINYINT(1)", nullable = false, insertable = false, updatable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean recebida;

	@ManyToOne(optional = false)
	@JoinColumn(name = "mensageiro", referencedColumnName = "prontuario", nullable = false, insertable = false, updatable = false)
	private UsuarioEntity mensageiro;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "receptor", referencedColumnName = "prontuario", nullable = false, insertable = false, updatable = false)
	private UsuarioEntity receptor;

	public MensagemEntity() {
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

	@Override
	public String toString() {
		return "MensagemEntity [mensagemEntityPK=" + mensagemEntityPK + ", texto=" + texto + ", dataEnvio=" + dataEnvio
				+ ", recebida=" + recebida + ", mensageiro=" + mensageiro + ", receptor=" + receptor + "]";
	}
	
}
