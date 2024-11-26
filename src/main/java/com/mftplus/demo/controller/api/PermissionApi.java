package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.Loggable;
import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
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
    @Loggable
    @ResponseMaker
    public Object getPermissions() {
        log.info("get Permissions:");
        return permissionService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @Loggable
    @ResponseMaker
    public Object getPermissionById(@PathParam("id") Long id) {
        return permissionService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{name}")
    @Loggable
    @ResponseMaker
    public Object getPermissionByName(@PathParam("name") String permissionName) {
        return permissionService.findByName(permissionName);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object addPermission(@Valid Permission permission) {
        permissionService.save(permission);
        return permission;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object updatePermission(@Valid Permission permission) {
        permissionService.edit(permission);
        return permission;
    }

    @DELETE
    @Path("{id}")
    public Response deletePermission(@PathParam("id") Long id) {
        permissionService.remove(id);
        return Response.ok().entity(id).build();
    }
}
