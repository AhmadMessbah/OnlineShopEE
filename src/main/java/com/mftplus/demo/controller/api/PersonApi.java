package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/persons")
@Slf4j
public class PersonApi {

    @Inject
    private PersonService personService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson() {
            log.info("Get Admin Info");
            return Response.ok().entity(personService.findAll()).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getPersonById(@PathParam("id") Long id) {
        return Response.ok().entity(personService.findById(id)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{nationalId}")
    public Response getPersonByNationalId(@PathParam("nationalId") String nationalId) {
        return Response.ok().entity(personService.findByNationalId(nationalId)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{fullName}")
    public Response getPersonByNameAndFamily(@PathParam("fullName") String name, String family) {
        return Response.ok().entity(personService.findByLastNameAndFirstName(name, family)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{loginData}")
    public Response getPersonByUsernameAndPassword(@PathParam("loginData") String username, String password) {
        return Response.ok().entity(personService.findByUsernameAndPassword(username, password)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{username}")
    public Response getPersonByUsername(@PathParam("username") String username) {
        return Response.ok().entity(personService.findByUsername(username)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{phone}")
    public Response getPersonByPhoneNumber(@PathParam("phone") String phoneNumber) {
        return Response.ok().entity(personService.findByPhoneNumber(phoneNumber)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{postCode}")
    public Response getPersonByPostalCode(@PathParam("postCode") String postalCode) {
        return Response.ok().entity(personService.findByPostalCode(postalCode)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{address}")
    public Response getPersonByAddress(@PathParam("address") String address) {
        return Response.ok().entity(personService.findByAddress(address)).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        personService.save(person);
        return Response.ok().entity(person).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person person) {
        personService.edit(person);
        return Response.ok().entity(person).build();
    }
    @DELETE
    @Path("{id}")
    public Response deletePerson(@PathParam("id") Long id) {
        personService.remove(id);
        return Response.ok().entity(id).build();
    }
}
