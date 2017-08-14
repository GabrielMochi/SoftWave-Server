package br.net.sofwave.server.service;

import br.net.sofwave.server.domain.Atividade;
import br.net.sofwave.server.domain.AtividadePK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

@Stateless
@Path("br.net.sofwave.server.domain.atividade")
public class AtividadeFacadeREST extends AbstractFacade<Atividade> {

    @PersistenceContext(unitName = "br.net.softwave_server_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;

    private AtividadePK getPrimaryKey(PathSegment pathSegment) {
        br.net.sofwave.server.domain.AtividadePK key = new br.net.sofwave.server.domain.AtividadePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> id = map.get("id");
        if (id != null && !id.isEmpty()) {
            key.setId(new java.lang.Integer(id.get(0)));
        }
        java.util.List<String> disciplinaId = map.get("disciplinaId");
        if (disciplinaId != null && !disciplinaId.isEmpty()) {
            key.setDisciplinaId(new java.lang.Integer(disciplinaId.get(0)));
        }
        java.util.List<String> disciplinaTurmaNumero = map.get("disciplinaTurmaNumero");
        if (disciplinaTurmaNumero != null && !disciplinaTurmaNumero.isEmpty()) {
            key.setDisciplinaTurmaNumero(new java.lang.Integer(disciplinaTurmaNumero.get(0)));
        }
        return key;
    }

    public AtividadeFacadeREST() {
        super(Atividade.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Atividade entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Atividade entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        br.net.sofwave.server.domain.AtividadePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Atividade find(@PathParam("id") PathSegment id) {
        br.net.sofwave.server.domain.AtividadePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Atividade> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Atividade> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
