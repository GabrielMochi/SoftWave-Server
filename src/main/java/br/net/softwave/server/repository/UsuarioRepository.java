package br.net.softwave.server.repository;

import br.net.softwave.server.entity.UsuarioEntity;

public class UsuarioRepository extends Repository<UsuarioEntity> {
	
	public UsuarioRepository() {
		super(UsuarioEntity.class);
	}
	
}
