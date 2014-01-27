/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas.service;

import com.polytech.ogas.Entreprise;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

/**
 *
 * @author epulapp
 */
@Stateless
@Path("entreprise")
public class EntrepriseFacadeREST extends AbstractFacade<Entreprise> {
    
    

    public EntrepriseFacadeREST() {
        super(Entreprise.class);
        
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Entreprise entity) {
        super.create(entity);
    }

    @PUT
    @Path("edit/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Short id, Entreprise entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("remove/{id}")
    public void remove(@PathParam("id") Short id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("find/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Entreprise find(@PathParam("id") Short id) {
        return super.find(id);
    }

    @GET
    @Path("findAll")
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Entreprise> findAll() {
        return super.findAll();
    }

    @GET
    @Path("findRange/{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Entreprise> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }    
}
