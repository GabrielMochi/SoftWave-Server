package br.net.softwave.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "areaConhecimento")
public class AreaConhecimentoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false, insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", nullable = false, insertable = false, updatable = false)
	private String nome;
	
	@OneToMany(mappedBy = "areaConhecimento")
	private List<PostagemEntity> postagemEntities;
	
	@OneToMany(mappedBy = "areaConhecimento")
	private List<AtividadeEntity> atividadeEntities;
	
	public AreaConhecimentoEntity() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PostagemEntity> getPostagemEntities() {
		return postagemEntities;
	}

	public void setPostagemEntities(List<PostagemEntity> postagemEntities) {
		this.postagemEntities = postagemEntities;
	}

	public List<AtividadeEntity> getAtividadeEntities() {
		return atividadeEntities;
	}

	public void setAtividadeEntities(List<AtividadeEntity> atividadeEntities) {
		this.atividadeEntities = atividadeEntities;
	}

	@Override
	public String toString() {
		return "AreaConhecimentoEntity [id=" + id + ", nome=" + nome + ", postagemEntities=" + postagemEntities
				+ ", atividadeEntities=" + atividadeEntities + "]";
	}
	
}
