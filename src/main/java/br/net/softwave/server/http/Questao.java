package br.net.softwave.server.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Questao {

	private int id;
	private String pergunta;
	private RespostaCorreta respostaCorreta;
	private Atividade atividade;
	private AreaConhecimento areaConhecimento;

	public Questao() {
	}

	public Questao(String pergunta, RespostaCorreta respostaCorreta, Atividade atividade,
			AreaConhecimento areaConhecimento) {
		this.pergunta = pergunta;
		this.respostaCorreta = respostaCorreta;
		this.atividade = atividade;
		this.areaConhecimento = areaConhecimento;
	}

	public Questao(int id, String pergunta, RespostaCorreta respostaCorreta, Atividade atividade,
			AreaConhecimento areaConhecimento) {
		this.id = id;
		this.pergunta = pergunta;
		this.respostaCorreta = respostaCorreta;
		this.atividade = atividade;
		this.areaConhecimento = areaConhecimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public RespostaCorreta getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(RespostaCorreta respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public enum RespostaCorreta {

		A("A"), B("B"), C("C"), D("D"), E("E");

		private final String valor;

		private RespostaCorreta(String valor) {
			this.valor = valor;
		}

		public String getValor() {
			return valor;
		}

	}

	@Override
	public String toString() {
		return "Questao [id=" + id + ", pergunta=" + pergunta + ", respostaCorreta=" + respostaCorreta + ", atividade="
				+ atividade + ", areaConhecimento=" + areaConhecimento + "]";
	}

}
