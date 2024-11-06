package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/users")
@Slf4j
public class UserApi {
    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        log.info("get users");
        return Response.ok().entity(userService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getUserById(@PathParam("id") Long id) {
        return Response.ok().entity(userService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/username/{username}")
    public Response getUserByUsername(@PathParam("username") String username) {
        return Response.ok().entity(userService.findByUsername(username)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{password}")
    public Response getUserByPassword(@PathParam("password") String password) {
        return Response.ok().entity(userService.findByPassword(password)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{logData}")
    public Response getUserByUsernameAndPassword(@PathParam("logData") String username , String password) {
        return Response.ok().entity(userService.findByUsernameAndPassword(username , password)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{email}")
    public Response getUserByEmail(@PathParam("email") String email) {
        return Response.ok().entity(userService.findByEmail(email)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{role}")
    public Response getUserByRoleName(@PathParam("role") String roleName) {
        return Response.ok().entity(userService.findByRoleName(roleName)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        userService.save(user);
        return Response.ok().entity(user).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        userService.edit(user);
        return Response.ok().entity(user).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        userService.remove(id);
        return Response.ok().entity(id).build();
    }
}
