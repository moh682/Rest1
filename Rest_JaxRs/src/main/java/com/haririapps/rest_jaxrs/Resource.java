/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haririapps.rest_jaxrs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import entity.PersonDTO;
import facade.PersonFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import jdk.nashorn.internal.objects.Global;

/**
 * REST Web Service
 *
 * @author mohammahomarhariri
 */
@Path("persons")
public class Resource {
    
    PersonFacade pf = new PersonFacade(Persistence.createEntityManagerFactory("pu", null));
    JSONConverter jsonc = new JSONConverter();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Resource
     */
    public Resource() {
    }

    /**
     * Retrieves representation of an instance of com.haririapps.rest_jaxrs.Resource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getPerson(@PathParam("id") Integer id) {
    
        //assign the value of the Json file into Person
       return JSONConverter.getJSONFromPerson(pf.getPerson(id));
        
        
    }

    /**
     * PUT method for updating or creating an instance of Resource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putPerson(String json) {
        
      //  return JSONConverter.getJSONFromPerson(pf.editPerson(JSONConverter.getPersonFromJson(json)));        
return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postPerson(String json){
        
        //return JSONConverter.getJSONFromPerson(pf.createPerson(JSONConverter.getPersonFromJson(json)));        
    
    return "";
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deletePerson(String json){
  //      return JSONConverter.getJSONFromPerson(pf.deletePerson(JSONConverter.getPersonFromJson(json)));
    return "";
    }
    
    @GET
    @Path("all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersons(){
        System.out.println("Resource GET resources");
        return JSONConverter.getJSONFromPersons(pf.getAllPersons());
    }
}
