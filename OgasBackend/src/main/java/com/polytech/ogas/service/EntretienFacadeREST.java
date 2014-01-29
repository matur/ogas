/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas.service;

import com.polytech.ogas.Entretien;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
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
@Path("entretiens")
public class EntretienFacadeREST extends AbstractFacade<Entretien> {
    
    public EntretienFacadeREST() {
        super(Entretien.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Entretien entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Entretien entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Entretien find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entretien> findAll() {
        return super.findAll();
    }

    @GET
    @Path("findRange/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entretien> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    public ArrayList<Entretien> findAllByIdEvenement(short idEvenement)
    {
        ArrayList<Entretien> entretiens = new ArrayList<Entretien>();
        Query entretiensQuery = getEntityManager().createQuery("Entretien.findByEvenementId");
        List entretiensResults = entretiensQuery.getResultList();
        for (Object entretien : entretiensResults) {
            entretiens.add((Entretien) entretien);
        }
        return entretiens;
    }
}
