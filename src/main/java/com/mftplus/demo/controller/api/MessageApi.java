package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Message;
import com.mftplus.demo.model.service.MessageService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/messages")
@Loggable
@Slf4j
public class MessageApi {
    @Inject
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMessages() {
        log.info("All Messages :");
        return Response.ok().entity(messageService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageById(@PathParam("id") Long id) {
        log.info("Get Message by id : {}", id);
        return Response.ok().entity(messageService.findById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMessage(@Valid Message message) {
        log.info("Create Message : {}", message);
        messageService.save(message);
        return Response.ok().entity(message).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMessage(@Valid Message message) {
        log.info("Update Message : {}", message);
        messageService.edit(message);
        return Response.ok().entity(message).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteMessage(@PathParam("id") Long id) {
        log.info("Delete Message : {}", id);
        messageService.remove(id);
        return Response.ok().entity(id).build();
    }
}
