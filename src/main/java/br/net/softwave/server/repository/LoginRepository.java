package br.net.softwave.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.net.softwave.server.entity.UsuarioEntity;

public class LoginRepository {
	
	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
	
	public LoginRepository() {
		// CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml
		entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_softwave"); // será alterado após acesso ao bdd da escola
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	/**
	 * Consulta se as credenciais correspondem.
	 * 
	 * @param prontuario id usado para a consulta na tabela
	 * @param senha segurança
	 * @return Caso as credenciais sejam válidas, o retorno será o usuário,
	 * caso contrário será retornado null como usuário
	 * */
	public UsuarioEntity consultar(String prontuario, String senha) throws Exception {
		/*Forma completa:
		 * return entityManager.createQuery("SELECT u FROM usuario u where u.prontuario = :prontuario AND u.senha = :senha")
				.setParameter("prontuario", prontuario)
				.setParameter("senha", senha)
				.getFirstResult();*/
		
		//Forma temporaria:
		
		return entityManager.find(UsuarioEntity.class, prontuario);
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
