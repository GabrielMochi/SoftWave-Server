package br.net.softwave.server.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataMessage {

	private String resposta;
	private boolean status;
	
	public DataMessage() {
	}
	
	public DataMessage(String resposta, boolean status) {
		this.resposta = resposta;
		this.status = status;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DataMessage [resposta=" + resposta + ", status=" + status + "]";
	}
	
}
