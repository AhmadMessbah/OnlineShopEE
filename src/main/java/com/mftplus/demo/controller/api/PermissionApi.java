package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Permission;
import com.mftplus.demo.model.service.PermissionService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/permissions")
@Slf4j
public class PermissionApi {
    @Inject
    private PermissionService permissionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPermissions() {
            log.info("get Permissions:");
            return Response.ok().entity(permissionService.findAll()).build();
    }
    //todo--->>>message to show the wrongs

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getPermissionById(@PathParam("id") Long id) {
        return Response.ok().entity(permissionService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{name}")
    public Response getPermissionByName(@PathParam("name") String permissionName) {
        return Response.ok().entity(permissionService.findByName(permissionName)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPermission(@Valid Permission permission) {
        permissionService.save(permission);
        return Response.ok().entity(permission).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePermission(@Valid Permission permission) {
        permissionService.edit(permission);
        return Response.ok().entity(permission).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePermission(@PathParam("id") Long id) {
        permissionService.remove(id);
        return Response.ok().entity(id).build();
    }
}
