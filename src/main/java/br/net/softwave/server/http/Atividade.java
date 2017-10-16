package br.net.softwave.server.http;

import java.time.LocalDateTime;
import java.util.List;

public class Atividade {

	private int id;
	private AreaConhecimento areaConhecimento;
	private String descricao;
	private LocalDateTime lancada;
	private List<Questao> questoes;
	
	public Atividade() {
	}

	public Atividade(AreaConhecimento areaConhecimento, String descricao, LocalDateTime lancada,
			List<Questao> questoes) {
		this.areaConhecimento = areaConhecimento;
		this.descricao = descricao;
		this.lancada = lancada;
		this.questoes = questoes;
	}

	public Atividade(int id, AreaConhecimento areaConhecimento, String descricao, LocalDateTime lancada,
			List<Questao> questoes) {
		this.id = id;
		this.areaConhecimento = areaConhecimento;
		this.descricao = descricao;
		this.lancada = lancada;
		this.questoes = questoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
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

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", areaConhecimento=" + areaConhecimento + ", descricao=" + descricao
				+ ", lancada=" + lancada + ", questoes=" + questoes + "]";
	}
	
}
