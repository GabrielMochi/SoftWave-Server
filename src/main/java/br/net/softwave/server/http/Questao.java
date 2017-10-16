package br.net.softwave.server.http;

public class Questao {

	private int id;
	private Atividade atividade;
	private String pergunta;
	private RespostaCorreta respostaCorreta;
	
	public Questao() {
	}
	
	public Questao(Atividade atividade, String pergunta, RespostaCorreta respostaCorreta) {
		this.atividade = atividade;
		this.pergunta = pergunta;
		this.respostaCorreta = respostaCorreta;
	}

	public Questao(int id, Atividade atividade, String pergunta, RespostaCorreta respostaCorreta) {
		this.id = id;
		this.atividade = atividade;
		this.pergunta = pergunta;
		this.respostaCorreta = respostaCorreta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
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
		return "Questao [id=" + id + ", atividade=" + atividade + ", pergunta=" + pergunta + 
				", respostaCorreta=" + respostaCorreta + "]";
	}
	
}
