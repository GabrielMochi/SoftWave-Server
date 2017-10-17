package br.net.softwave.server.endpoint.encoder;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import br.net.softwave.server.entity.MensagemEntity;

public class MensagemEncoder implements Encoder.Text<MensagemEntity> {
	
	private final static Gson gson = new Gson();
	
	@Override
	public String encode(MensagemEntity mensagem) throws EncodeException {
		return gson.toJson(mensagem);
	}
	
	@Override
	public void init(EndpointConfig endpointConfig) {
	}
	
	@Override
	public void destroy() {
	}
	
}
