/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas.service;

import com.polytech.ogas.Evenement;
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

/**
 *
 * @author epulapp
 */
@Stateless
@Path("/evenement")
public class EvenementFacadeREST extends AbstractFacade<Evenement> {
    @PersistenceContext(unitName = "com.polytech_OgasBackend_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public EvenementFacadeREST() {
        super(Evenement.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Evenement entity) {
        super.create(entity);
    }

    @PUT
    @Path("edit/{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Short id, Evenement entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("remove/{id}")
    public void remove(@PathParam("id") Short id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("find/{id}")
    @Produces({"application/xml", "application/json"})
    public Evenement find(@PathParam("id") Short id) {
        return super.find(id);
    }

    @GET
    @Path("findAll")
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Evenement> findAll() {
        return super.findAll();
    }

    @GET
    @Path("findRange/{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Evenement> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
