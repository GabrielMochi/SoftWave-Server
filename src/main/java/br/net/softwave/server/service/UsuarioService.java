package br.net.softwave.server.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import br.net.softwave.server.entity.UsuarioEntity;
import br.net.softwave.server.http.Usuario;
import br.net.softwave.server.http.Usuario.Permissao;
import br.net.softwave.server.repository.UsuarioRepository;

@Path("usuario")
public class UsuarioService extends Service<Usuario, UsuarioEntity, String> {

	public UsuarioService() {
		super(new UsuarioRepository());
	}

	@Override
	public void salvar(Usuario object) throws Exception {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setProntuario(object.getProntuario());
		usuarioEntity.setPermissao(object.getPermissao().getValor());
		getRepository().salvar(usuarioEntity);
	}

	@Override
	public void alterar(Usuario object) throws Exception {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setProntuario(object.getProntuario());
		usuarioEntity.setPermissao(object.getPermissao().getValor());
		getRepository().alterar(usuarioEntity);
	}

	@Override
	public List<Usuario> pegarTodos() throws Exception {
		List<Usuario> usuarios = new ArrayList<>();
		List<UsuarioEntity> usuarioEntities = getRepository().pegarTodos("SELECT u FROM UsuarioEntity u");
		
		for (UsuarioEntity usuarioEntity : usuarioEntities) {
			switch (usuarioEntity.getPermissao()) {
				case "ALUNO":
					usuarios.add(new Usuario(usuarioEntity.getProntuario(), Permissao.ALUNO));
					break;
				case "PROFESSOR":
					usuarios.add(new Usuario(usuarioEntity.getProntuario(), Permissao.PROFESSOR));
					break;
				case "ADMIN":
					usuarios.add(new Usuario(usuarioEntity.getProntuario(), Permissao.ADMIN));
					break;
				default:
					throw new Exception();
			}
		}
		
		return usuarios;
	}

	@Override
	public Usuario pegar(String id) throws Exception {
		UsuarioEntity usuarioEntity = getRepository().pegar(id);
		
		if (usuarioEntity != null) {
			switch (usuarioEntity.getPermissao()) {
				case "ALUNO":
					return new Usuario(usuarioEntity.getProntuario(), Permissao.ALUNO);
				case "PROFESSOR":
					return new Usuario(usuarioEntity.getProntuario(), Permissao.PROFESSOR);
				case "ADMIN":
					return new Usuario(usuarioEntity.getProntuario(), Permissao.ADMIN);
				default:
					throw new Exception();
			}
		}
		
		return null;
	}

	@Override
	public void remover(String id) throws Exception {
		getRepository().remover(id);
	}

}
