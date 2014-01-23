/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas.service;

import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


/**
 * REST Web Service
 *
 * @author epulapp
 */
@Path("planning")
public class PlanningFacadeREST {
    @Context
    private UriInfo context;
    /**
     * Creates a new instance of PlanningFacadeREST
     */
    public PlanningFacadeREST() {
    }

    @GET
    @Path("computeplanning/{id}")
    @Produces("application/json")
    public String computePlanning(@PathParam("id") Short idEvenement) {
        return "compute planning !";
    }
    
    @GET
    @Path("getplanning/{id}")
    @Produces("application/json")
    public String getPlanning(@PathParam("id") Short idEvenement) {
        return "get planning !";
    }
}
