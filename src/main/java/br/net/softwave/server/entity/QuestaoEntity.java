package br.net.softwave.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questao")
public class QuestaoEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "pergunta", nullable = false)
	private String pergunta;
	
	@Column(name = "respostaCorreta", nullable = false)
	@Size(min = 1, max = 1)
	private String respostaCorreta;
	
	@Column(name = "atividade_id", nullable = false)
	@ManyToOne
	private AtividadeEntity atividade;
	
	@Column(name = "atividade_areaConhecimento_id", nullable = false)
	@ManyToOne
	private AreaConhecimentoEntity areaConhecimento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public AreaConhecimentoEntity areaConhecimento() {
		return areaConhecimento;
	}

	public void setAtividade_areaConhecimento_id(AreaConhecimentoEntity areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	
}
