package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.ProductGroup;
import com.mftplus.demo.model.service.ProductGroupService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/ProductsGroups")
@Slf4j

public class ProductGroupApi {
    @Inject
    private ProductGroupService productGroupService;

    @GET
    @Produces
    public Response getProductGroups() {
        log.info("getProductGroups");
        return Response.ok().entity(productGroupService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductGroupById(@PathParam("id") Long id) {
        log.info("getProductGroupById");
        return Response.ok().entity(productGroupService.findById(id)).build();
    }
    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductGroupByName(@PathParam("name") String name) {
        log.info("getProductGroupByName");
        return Response.ok().entity(productGroupService.findByName(name)).build();
    }
    @GET
    @Path("/child/{child}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductGroupByChild(@PathParam("child") String child) {
        log.info("getProductGroupByChild");
        return Response .ok().entity(productGroupService.findByChild(child)).build();
    }
    @GET
    @Path("/parent/{parent}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductGroupByParent(@PathParam("parent") String parent) {
        log.info("getProductGroupByParent");
        return Response.ok().entity(productGroupService.findByParent(parent)).build();

    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProductGroup(@Valid ProductGroup productGroup) {
        log.info("addProductGroup");
        productGroupService.save(productGroup);
        return Response.ok().entity(productGroup).build();


    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProductGroup(@Valid ProductGroup productGroup) {
        log.info("edit ProductGroup");
        productGroupService.edit(productGroup);
        return Response.ok().entity(productGroup).build();


    }
    @DELETE
    @Path("{id}")
    public Response removeProductGroupById(@PathParam("id") Long id) {
        log.info("remove ProductGroupById");
        productGroupService.remove(id);
        return Response.ok().entity(id).build();
    }



}
