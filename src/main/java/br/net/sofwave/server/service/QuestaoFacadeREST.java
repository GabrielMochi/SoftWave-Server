/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.sofwave.server.service;

import br.net.sofwave.server.domain.Questao;
import br.net.sofwave.server.domain.QuestaoPK;
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
@Path("br.net.sofwave.server.domain.questao")
public class QuestaoFacadeREST extends AbstractFacade<Questao> {

    @PersistenceContext(unitName = "br.net.softwave_server_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;

    private QuestaoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;id=idValue;atividadeId=atividadeIdValue;atividadeDisciplinaId=atividadeDisciplinaIdValue;atividadeDisciplinaTurmaNumero=atividadeDisciplinaTurmaNumeroValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        br.net.sofwave.server.domain.QuestaoPK key = new br.net.sofwave.server.domain.QuestaoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> id = map.get("id");
        if (id != null && !id.isEmpty()) {
            key.setId(new java.lang.Integer(id.get(0)));
        }
        java.util.List<String> atividadeId = map.get("atividadeId");
        if (atividadeId != null && !atividadeId.isEmpty()) {
            key.setAtividadeId(new java.lang.Integer(atividadeId.get(0)));
        }
        java.util.List<String> atividadeDisciplinaId = map.get("atividadeDisciplinaId");
        if (atividadeDisciplinaId != null && !atividadeDisciplinaId.isEmpty()) {
            key.setAtividadeDisciplinaId(new java.lang.Integer(atividadeDisciplinaId.get(0)));
        }
        java.util.List<String> atividadeDisciplinaTurmaNumero = map.get("atividadeDisciplinaTurmaNumero");
        if (atividadeDisciplinaTurmaNumero != null && !atividadeDisciplinaTurmaNumero.isEmpty()) {
            key.setAtividadeDisciplinaTurmaNumero(new java.lang.Integer(atividadeDisciplinaTurmaNumero.get(0)));
        }
        return key;
    }

    public QuestaoFacadeREST() {
        super(Questao.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Questao entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Questao entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        br.net.sofwave.server.domain.QuestaoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Questao find(@PathParam("id") PathSegment id) {
        br.net.sofwave.server.domain.QuestaoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Questao> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Questao> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
