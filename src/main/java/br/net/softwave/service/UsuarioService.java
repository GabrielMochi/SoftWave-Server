package br.net.softwave.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import br.net.softwave.entity.UsuarioEntity;
import br.net.softwave.http.Usuario;
import br.net.softwave.http.Usuario.Permissao;
import br.net.softwave.repository.UsuarioRepository;

@Path("usuario")
public class UsuarioService extends Service<Usuario, UsuarioEntity, String> {

	public UsuarioService() {
		super(new UsuarioRepository());
	}

	@Override
	public void salvar(Usuario object) throws Exception {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		try {
			usuarioEntity.setProntuario(object.getProntuario());
			usuarioEntity.setPermissao(object.getPermissao());
			getRepository().salvar(usuarioEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void alterar(Usuario object) throws Exception {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		try {
			usuarioEntity.setProntuario(object.getProntuario());
			usuarioEntity.setPermissao(object.getPermissao());
			getRepository().alterar(usuarioEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Usuario> pegarTodos() throws Exception {
		try {
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
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Usuario pegar(String id) throws Exception {
		try {
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
		} catch (Exception e) {
			throw e;
		}
		
		return null;
	}

	@Override
	public void remover(String id) throws Exception {
		try {
			getRepository().remover(id);
		} catch (Exception e) {
			throw e;
		}
	}

}
