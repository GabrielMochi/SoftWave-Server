/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author gmoch
 */
@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.net.sofwave.server.service.AreaconhecimentoFacadeREST.class);
        resources.add(br.net.sofwave.server.service.AtividadeFacadeREST.class);
        resources.add(br.net.sofwave.server.service.BlogFacadeREST.class);
        resources.add(br.net.sofwave.server.service.ComentarioFacadeREST.class);
        resources.add(br.net.sofwave.server.service.DisciplinaFacadeREST.class);
        resources.add(br.net.sofwave.server.service.MensagemFacadeREST.class);
        resources.add(br.net.sofwave.server.service.QuestaoFacadeREST.class);
        resources.add(br.net.sofwave.server.service.TurmaFacadeREST.class);
        resources.add(br.net.sofwave.server.service.UsuarioFacadeREST.class);
    }
    
}
