package br.net.softwave.server.service;

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

import br.net.softwave.server.repository.Repository;

/**
 * @param <T> Classe entidade
 * @param <P> O tipo da chave primária. Ex.: Integer, String, etc.
 * */
public abstract class Service<T, P> {
	
	private final Repository<T> repository;
	
	public Service(Repository<T> repository) {
		this.repository = repository;
	}
	
	/**
	 * HTTP POST -> Salva um novo elemento.
	 * */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("salvar")
	public abstract void salvar(T object) throws Exception;
	
	/**
	 * HTTP PUT -> Altera um elemento pelo id.
	 * */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("alterar")
	public abstract void alterar(T object) throws Exception;
	
	/**
	 * HTTP GET -> Pega todos os elementos.
	 * */
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("pegarTodos")
	public abstract List<T> pegarTodos() throws Exception;
	
	/**
	 * HTTP GET -> Pega um elemento pelo id.
	 * */
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("pegar/{id}")
	public abstract T pegar(@PathParam("id") P id) throws Exception;
	
	/**
	 * HTTP DELETE -> Deleta um elemento pelo id.
	 * */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("remover/{id}")
	public abstract void remover(@PathParam("id") P id) throws Exception;

	public Repository<T> getRepository() {
		return repository;
	}
	
}
