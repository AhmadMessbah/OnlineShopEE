package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.service.RoleService;
import jakarta.inject.Inject;
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
    public Response getRoles() {
        log.info("get roles");
        return Response.ok().entity(roleService.findAll()).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getRoleById(@PathParam("id") Long id) {
        return Response.ok().entity(roleService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{type}")
    public Response getRoleByName(@PathParam("type") String roleName) {
        return Response.ok().entity(roleService.findByRoleName(roleName)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{permission}")
    public Response getRoleByPermissionName(@PathParam("permission") String permissionName) {
        return Response.ok().entity(roleService.findByPermission(permissionName)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRole(Role role)  {
        roleService.save(role);
        return Response.ok().entity(roleService).build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRole(Role role)  {
        roleService.edit(role);
        return Response.ok().entity(roleService).build();
    }
    @DELETE
    @Path("{id}")
    public Response deleteRole(@PathParam("id") Long id) {
        roleService.remove(id);
        return Response.ok().entity(id).build();
    }

}
