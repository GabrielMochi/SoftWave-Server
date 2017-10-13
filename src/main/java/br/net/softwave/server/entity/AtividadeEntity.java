package br.net.softwave.server.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atividade")
public class AtividadeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AtividadeEntityPK atividadeEntityPK;
	
	@Lob
	@Column(name = "descricao", nullable = false, insertable = false, updatable = false)
	private String descricao;
	
	@Column(name = "lancada", columnDefinition = "DATETIME", nullable = false, insertable = false, updatable = false)
	private LocalDateTime lancada;
	
	@ManyToOne
	@JoinColumn(name = "areaConhecimento_id", referencedColumnName = "id")
	private AreaConhecimentoEntity areaConhecimento;
	
	@OneToMany(mappedBy = "atividade")
	private List<QuestaoEntity> questao;
	
	public AtividadeEntity() {
	}

	public AtividadeEntityPK getAtividadeEntityPK() {
		return atividadeEntityPK;
	}

	public void setAtividadeEntityPK(AtividadeEntityPK atividadeEntityPK) {
		this.atividadeEntityPK = atividadeEntityPK;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getLancada() {
		return lancada;
	}

	public void setLancada(LocalDateTime lancada) {
		this.lancada = lancada;
	}

	public AreaConhecimentoEntity getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimentoEntity areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public List<QuestaoEntity> getQuestao() {
		return questao;
	}

	public void setQuestao(List<QuestaoEntity> questao) {
		this.questao = questao;
	}

	@Override
	public String toString() {
		return "AtividadeEntity [atividadeEntityPK=" + atividadeEntityPK + ", descricao=" + descricao + ", lancada="
				+ lancada + ", areaConhecimento=" + areaConhecimento + ", questao=" + questao + "]";
	}
	
}
