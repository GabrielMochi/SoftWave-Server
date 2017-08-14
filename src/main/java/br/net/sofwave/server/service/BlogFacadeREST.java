/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.sofwave.server.service;

import br.net.sofwave.server.domain.Blog;
import br.net.sofwave.server.domain.BlogPK;
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
@Path("br.net.sofwave.server.domain.blog")
public class BlogFacadeREST extends AbstractFacade<Blog> {

    @PersistenceContext(unitName = "br.net.softwave_server_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;

    private BlogPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;id=idValue;usuarioProntuario=usuarioProntuarioValue;areaConhecimentoid=areaConhecimentoidValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        br.net.sofwave.server.domain.BlogPK key = new br.net.sofwave.server.domain.BlogPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> id = map.get("id");
        if (id != null && !id.isEmpty()) {
            key.setId(new java.lang.Integer(id.get(0)));
        }
        java.util.List<String> usuarioProntuario = map.get("usuarioProntuario");
        if (usuarioProntuario != null && !usuarioProntuario.isEmpty()) {
            key.setUsuarioProntuario(new java.lang.Integer(usuarioProntuario.get(0)));
        }
        java.util.List<String> areaConhecimentoid = map.get("areaConhecimentoid");
        if (areaConhecimentoid != null && !areaConhecimentoid.isEmpty()) {
            key.setAreaConhecimentoid(new java.lang.Integer(areaConhecimentoid.get(0)));
        }
        return key;
    }

    public BlogFacadeREST() {
        super(Blog.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Blog entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Blog entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        br.net.sofwave.server.domain.BlogPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Blog find(@PathParam("id") PathSegment id) {
        br.net.sofwave.server.domain.BlogPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Blog> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Blog> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
