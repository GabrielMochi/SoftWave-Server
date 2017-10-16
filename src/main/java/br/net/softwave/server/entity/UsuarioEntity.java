package br.net.softwave.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.net.softwave.server.http.Postagem;

@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "prontuario", nullable = false, insertable = false, updatable = false)
	@Size(max = 8)
	private String prontuario;
	
	@Column(name = "permissao", nullable = false, insertable = false, updatable = false)
	@Size(min = 1, max = 9)
	private String permissao;
	
	@OneToMany(mappedBy = "usuario")
	private List<PostagemEntity> postagemEntities;
	
	@OneToMany(mappedBy = "mensageiro")
	private List<MensagemEntity> mensagemEntities;
	
	public UsuarioEntity() {
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public List<PostagemEntity> getPostagemEntities() {
		return postagemEntities;
	}
	
	public void setPostagemEntities(List<PostagemEntity> postagemEntities) {
		this.postagemEntities = postagemEntities;
	}

	public List<MensagemEntity> getMensagemEntities() {
		return mensagemEntities;
	}

	public void setMensagemEntities(List<MensagemEntity> mensagemEntities) {
		this.mensagemEntities = mensagemEntities;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [prontuario=" + prontuario + ", permissao=" + permissao + ", postagemEntities="
				+ postagemEntities + ", mensagemEntities=" + mensagemEntities + "]";
	}

}
