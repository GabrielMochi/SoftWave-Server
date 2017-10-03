package br.net.softwave.server.endpoint;

import java.io.IOException;
import java.util.HashMap;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import br.net.softwave.server.endpoint.decoder.MensagemDecoder;
import br.net.softwave.server.endpoint.encoder.MensagemEncoder;
import br.net.softwave.server.entity.UsuarioEntity;
import br.net.softwave.server.http.Mensagem;
import br.net.softwave.server.repository.UsuarioRepository;

@ServerEndpoint(
		value = "/chat/{prontuario}",
		decoders = MensagemDecoder.class,
		encoders = MensagemEncoder.class
)
public class ChatEndpoint {
	
	public static HashMap<Session, UsuarioEntity> usuarios = new HashMap<>();
	private static final UsuarioRepository repositorio = new UsuarioRepository();
	
	@OnOpen
	public void onOpen(final Session session, final @PathParam("prontuario") String prontuario) throws Exception {
		ChatEndpoint.usuarios.put(session, repositorio.pegar(prontuario));
	}
	
	@OnMessage
	public void onMessage(final Session session, final Mensagem mensagem) throws IOException, EncodeException {
		broadcast(mensagem);
	}
	
	@OnClose
	public void onClose(final Session session) throws IOException {
		ChatEndpoint.usuarios.remove(session);
	}
	
	@OnError
	public void onError(final Session session, final Throwable throwable) {
		// Tratamento de erro
	}
	
	private static void broadcast(final Mensagem mensagem) throws IOException, EncodeException {
		usuarios.forEach((session, usuario) -> {
			synchronized (session) {
				if (usuario.equals(mensagem.getReceptor())) {
					try {
						session.getBasicRemote().sendObject(mensagem);
					} catch (IOException | EncodeException e) {
						e.printStackTrace();
					}
					
					return;
				}
			}
		});
	}
	
}
