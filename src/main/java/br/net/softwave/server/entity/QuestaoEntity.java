package br.net.softwave.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questao")
public class QuestaoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuestaoEntityPK questaoEntityPK;
	
	@Lob
	@Column(name = "pergunta", nullable = false, insertable = false, updatable = false)
	private String pergunta;
	
	@Column(name = "respostaCorreta", nullable = false, insertable = false, updatable = false)
	@Size(min = 1, max = 1)
	private String respostaCorreta;
	
	@ManyToOne(optional = false)
	@JoinColumns({ 
		@JoinColumn(name = "atividade_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false),
		@JoinColumn(name = "atividade_areaConhecimento_id", referencedColumnName = "areaConhecimento_id", nullable = false, 
					insertable = false, updatable = false)
	})
	private AtividadeEntity atividade;
	
	public QuestaoEntity() {
	}

	public QuestaoEntityPK getQuestaoEntityPK() {
		return questaoEntityPK;
	}

	public void setQuestaoEntityPK(QuestaoEntityPK questaoEntityPK) {
		this.questaoEntityPK = questaoEntityPK;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(String respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}

	public AtividadeEntity getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadeEntity atividade) {
		this.atividade = atividade;
	}

	@Override
	public String toString() {
		return "QuestaoEntity [questaoEntityPK=" + questaoEntityPK + ", pergunta=" + pergunta + ", respostaCorreta="
				+ respostaCorreta + ", atividade=" + atividade + "]";
	}
	
}
