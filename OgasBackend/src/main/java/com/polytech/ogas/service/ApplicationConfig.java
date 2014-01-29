/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author epulapp
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
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
        resources.add(com.polytech.ogas.security.OgasCrossOriginResourceSharingFilter.class);
        resources.add(com.polytech.ogas.service.EntrepriseFacadeREST.class);
        resources.add(com.polytech.ogas.service.EntretienFacadeREST.class);
        resources.add(com.polytech.ogas.service.EtudiantFacadeREST.class);
        resources.add(com.polytech.ogas.service.EvenementFacadeREST.class);
        resources.add(com.polytech.ogas.service.PersonnecontactFacadeREST.class);
        resources.add(com.polytech.ogas.service.PlanningFacadeREST.class);
        resources.add(com.polytech.ogas.service.SalleFacadeREST.class);
        resources.add(com.polytech.ogas.service.UtilisateurFacadeREST.class);
    }
    
}
