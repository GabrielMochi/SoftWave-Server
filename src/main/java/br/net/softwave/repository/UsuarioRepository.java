package br.net.softwave.repository;

import br.net.softwave.entity.UsuarioEntity;

public class UsuarioRepository extends Repository<UsuarioEntity> {
	
	public UsuarioRepository() {
		super(UsuarioEntity.class);
	}
	
}
