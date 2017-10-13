package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String prontuario;

	private String permissoes;

	//bi-directional many-to-one association to Mensagem
	@OneToMany(mappedBy="usuario1")
	private List<Mensagem> mensagems1;

	//bi-directional many-to-one association to Mensagem
	@OneToMany(mappedBy="usuario2")
	private List<Mensagem> mensagems2;

	public Usuario() {
	}

	public String getProntuario() {
		return this.prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getPermissoes() {
		return this.permissoes;
	}

	public void setPermissoes(String permissoes) {
		this.permissoes = permissoes;
	}

	public List<Mensagem> getMensagems1() {
		return this.mensagems1;
	}

	public void setMensagems1(List<Mensagem> mensagems1) {
		this.mensagems1 = mensagems1;
	}

	public Mensagem addMensagems1(Mensagem mensagems1) {
		getMensagems1().add(mensagems1);
		mensagems1.setUsuario1(this);

		return mensagems1;
	}

	public Mensagem removeMensagems1(Mensagem mensagems1) {
		getMensagems1().remove(mensagems1);
		mensagems1.setUsuario1(null);

		return mensagems1;
	}

	public List<Mensagem> getMensagems2() {
		return this.mensagems2;
	}

	public void setMensagems2(List<Mensagem> mensagems2) {
		this.mensagems2 = mensagems2;
	}

	public Mensagem addMensagems2(Mensagem mensagems2) {
		getMensagems2().add(mensagems2);
		mensagems2.setUsuario2(this);

		return mensagems2;
	}

	public Mensagem removeMensagems2(Mensagem mensagems2) {
		getMensagems2().remove(mensagems2);
		mensagems2.setUsuario2(null);

		return mensagems2;
	}

}