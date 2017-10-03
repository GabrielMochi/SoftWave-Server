package br.net.softwave.server.endpoint.decoder;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import br.net.softwave.server.http.Mensagem;

public class MensagemDecoder implements Decoder.Text<Mensagem> {

	private static final Gson gson = new Gson();
	
	@Override
	public Mensagem decode(String json) throws DecodeException {
		return gson.fromJson(json, Mensagem.class);
	}
	
	@Override
	public boolean willDecode(String json) {
		return json != null;
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig endpointConfig) {
	}

}
