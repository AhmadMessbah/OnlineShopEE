package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.GroupProperty;
import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.service.GroupPropertyService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/properties")
@Slf4j
public class GroupPropertyApi {
    @Inject
    private GroupPropertyService groupPropertyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProperties() {
        return Response.ok().entity(groupPropertyService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") Long id) {
        return Response.ok().entity(groupPropertyService.findById(id)).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProperty(@Valid GroupProperty groupProperty) {
        groupPropertyService.save(groupProperty);
        return Response.ok().entity(groupProperty).build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProperty(@Valid GroupProperty groupProperty) {
        groupPropertyService.edit(groupProperty);
        return Response.ok().entity(groupProperty).build();

    }
}
