package br.net.softwave.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.net.softwave.server.http.Usuario.Permissao;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
	
	@Id
	@Column(name="prontuario")
	@Size(max = 8)
	private String prontuario;
	
	@Column(name="permissao")
	@Size(min = 1, max = 9)
	private String permissao;
	
	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao.getTypeSelected();
	}
	
}
