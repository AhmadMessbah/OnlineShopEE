package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.GroupProperty;
import com.mftplus.demo.model.entity.ProductPropertyValue;
import com.mftplus.demo.model.service.ProductPropertyValueService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/values")
public class ProPropertyValueApi {
    @Inject
    private ProductPropertyValueService productPropertyValueService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getValues() {
        return Response.ok().entity(productPropertyValueService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getValuesById(@PathParam("id") Long id) {
        return Response.ok().entity(productPropertyValueService.findById(id)).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addValues(@Valid ProductPropertyValue productPropertyValue) {
        productPropertyValueService.save(productPropertyValue);
        return Response.ok().entity(productPropertyValue).build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateValues(@Valid ProductPropertyValue productPropertyValue) {
        productPropertyValueService.edit(productPropertyValue);
        return Response.ok().entity(productPropertyValue).build();

    }
}
