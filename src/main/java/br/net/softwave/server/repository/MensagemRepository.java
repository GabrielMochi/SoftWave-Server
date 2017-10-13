package br.net.softwave.server.repository;

import br.net.softwave.server.entity.MensagemEntity;

public class MensagemRepository extends Repository<MensagemEntity> {

	public MensagemRepository() {
		super(MensagemEntity.class);
	}
	
}
