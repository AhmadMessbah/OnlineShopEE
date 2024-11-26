package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.Loggable;
import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.service.RoleService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/roles")
@Slf4j
public class RoleApi {
    @Inject
    private RoleService roleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getRoles() {
        log.info("get roles");
        return roleService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @Loggable
    @ResponseMaker
    public Object getRoleById(@PathParam("id") Long id) {
        return roleService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/type/{type}")
    @Loggable
    @ResponseMaker
    public Object getRoleByName(@PathParam("type") String roleName) {
        return roleService.findByRoleName(roleName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/permission/{permission}")
    @Loggable
    @ResponseMaker

    public Object getRoleByPermissionName(@PathParam("permission") String permissionName) {
        return roleService.findByPermission(permissionName);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object addRole(@Valid Role role) {
        roleService.save(role);
        return role;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object updateRole(@Valid Role role) {
        roleService.edit(role);
        return role;
    }

    @DELETE
    @Path("{id}")
    //todo
    public Response deleteRole(@PathParam("id") Long id) {
        roleService.remove(id);
        return Response.ok().entity(id).build();
    }
}
