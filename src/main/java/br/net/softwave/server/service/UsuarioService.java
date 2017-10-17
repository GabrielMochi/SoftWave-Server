package br.net.softwave.server.service;

import java.util.List;

import javax.ws.rs.Path;

import br.net.softwave.server.entity.UsuarioEntity;
import br.net.softwave.server.repository.UsuarioRepository;

@Path("usuario")
public class UsuarioService extends Service<UsuarioEntity, String> {

	public UsuarioService() {
		super(new UsuarioRepository());
	}

	@Override
	public void salvar(UsuarioEntity object) throws Exception {
		getRepository().salvar(object);
	}

	@Override
	public void alterar(UsuarioEntity object) throws Exception {
		getRepository().alterar(object);
	}

	@Override
	public List<UsuarioEntity> pegarTodos() throws Exception {
		List<UsuarioEntity> usuarioEntities = getRepository().pegarTodos("SELECT u FROM UsuarioEntity u");
		System.out.println(usuarioEntities);
		return usuarioEntities;
	}

	@Override
	public UsuarioEntity pegar(String id) throws Exception {
		return getRepository().pegar(id);
	}

	@Override
	public void remover(String id) throws Exception {
		getRepository().remover(id);
	}

}
