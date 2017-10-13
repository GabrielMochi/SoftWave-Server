package br.net.softwave.server.http;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Atividade {

	private int id;
	private String descricao;
	private LocalDateTime lancada;
	private AreaConhecimento areaConhecimento;
	
	public Atividade()  {
	}
	
	public Atividade(String descricao, LocalDateTime lancada, AreaConhecimento areaConhecimento) {
		this.descricao = descricao;
		this.lancada = lancada;
		this.areaConhecimento = areaConhecimento;
	}
	
	public Atividade(int id, String descricao, LocalDateTime lancada, AreaConhecimento areaConhecimento) {
		this.id = id;
		this.descricao = descricao;
		this.lancada = lancada;
		this.areaConhecimento = areaConhecimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", descricao=" + descricao + ", lancada=" + lancada + ", areaConhecimento="
				+ areaConhecimento + "]";
	}

}
