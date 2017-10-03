package br.net.softwave.server.endpoint.encoder;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import br.net.softwave.server.http.Mensagem;

public class MensagemEncoder implements Encoder.Text<Mensagem> {
	
	private final static Gson gson = new Gson();
	
	@Override
	public String encode(Mensagem mensagem) throws EncodeException {
		return gson.toJson(mensagem);
	}
	
	@Override
	public void init(EndpointConfig endpointConfig) {
	}
	
	@Override
	public void destroy() {
	}
	
}
