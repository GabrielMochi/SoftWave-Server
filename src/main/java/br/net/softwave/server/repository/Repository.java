package br.net.softwave.server.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @param <T> Classe entidade
 * */
public abstract class Repository<T> {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
	private final Class<T> entityClass;
	
	public Repository(Class<T> typeParameterClass) {
		// CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml
		entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_softwave");
		entityManager = entityManagerFactory.createEntityManager();
		
		// Defini qual será o class do objeto
		this.entityClass = typeParameterClass;
	}
	
	/**
	 * Cria um novo registro na tabela.
	 * 
	 * @param entity objeto que deverá ser salvo
	 * */
	public void salvar(T entity) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Altera um registro na tabela.
	 * 
	 * @param entity objeto que deverá ser alterado
	 * */
	public void alterar(T entity) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}
	
	/**
	 * Consulta todas os registros na tabela.
	 * 
	 * @param query query para consultar todos os objeto em uma determinada
	 * tabela. Ex.: SELECT u FROM UsuarioEntity u
	 * @return Lista de objetos consultados
	 * */
	@SuppressWarnings("unchecked")
	public List<T> pegarTodos(String query) throws Exception {
		return this.entityManager.createQuery(query).getResultList();
	}
	
	/**
	 * Consulta um único registro pelo id próprio na tabela.
	 * 
	 * @param <P> O tipo da chave primária. Ex.: Inteeger, String, etc.
	 * @param id id próprio que será utlizado para consulta
	 * @return Objeto consultado
	 * */
	public <P> T pegar(P id) throws Exception {
		return entityManager.find(entityClass, id);
	}
	
	/**
	 * Remove um único registro pelo id próprio na tabela.
	 * 
	 * @param <P> O tipo da chave primária. Ex.: Inteeger, String, etc.
	 * @param id id próprio que será utlizado para remoção
	 * */
	public <P> void remover(P id) throws Exception {
		entityManager.getTransaction().begin();
		entityManager.remove(pegar(id));
		entityManager.getTransaction().commit();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}
	
}
