package br.net.softwave.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.net.softwave.repository.Repository;

/**
 * @param <T> Classe é http
 * @param <E> Classe entidade
 * @param <P> O tipo da chave primária. Ex.: Inteeger, String, etc.
 * */
public abstract class Service<T, E, P> {
	
	private final Repository<E> repository;
	
	public Service(Repository<E> repository) {
		this.repository = repository;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("salvar")
	public abstract void salvar(T object) throws Exception;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("alterar")
	public abstract void alterar(T object) throws Exception;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pegarTodos")
	public abstract List<T> pegarTodos() throws Exception;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pegar/{id}")
	public abstract T pegar(@PathParam("id") P id) throws Exception;
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("remover/{id}")
	public abstract void remover(@PathParam("id") P id) throws Exception;

	public Repository<E> getRepository() {
		return repository;
	}
	
}
