package br.net.softwave.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.net.softwave.entity.UsuarioEntity;
import br.net.softwave.http.Credenciais;
import br.net.softwave.http.Usuario;
import br.net.softwave.http.Usuario.Permissao;
import br.net.softwave.repository.LoginRepository;

@Path("login")
public class LoginService {

	private final LoginRepository repository;
	
	public LoginService() {
		this.repository = new LoginRepository();
	}
	
	/**
	 * HTTP POST -> Consulta se as credenciais correspondem.
	 * */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario consultar(Credenciais credenciais) throws Exception {
		UsuarioEntity usuarioEntity = repository.consultar(credenciais.getProntuario(), credenciais.getSenha());
		
		if (usuarioEntity != null)
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
		
		return null;
	}
	
}
