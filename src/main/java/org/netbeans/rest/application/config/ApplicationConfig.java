package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Não modifique o método addRestResourceClasses().
     * Ele é preenchido automaticamente com todos os
     * recursos definidos no projeto. 
     * Se necessário, comente esse método em getClasses ().
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
