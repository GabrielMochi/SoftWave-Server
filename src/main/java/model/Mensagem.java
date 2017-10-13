package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mensagem database table.
 * 
 */
@Entity
@NamedQuery(name="Mensagem.findAll", query="SELECT m FROM Mensagem m")
public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MensagemPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvio;

	private byte recebida;

	@Lob
	private String texto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="mensageiro")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="receptor")
	private Usuario usuario2;

	public Mensagem() {
	}

	public MensagemPK getId() {
		return this.id;
	}

	public void setId(MensagemPK id) {
		this.id = id;
	}

	public Date getDataEnvio() {
		return this.dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public byte getRecebida() {
		return this.recebida;
	}

	public void setRecebida(byte recebida) {
		this.recebida = recebida;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}