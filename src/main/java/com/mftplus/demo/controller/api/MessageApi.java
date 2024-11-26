package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.Loggable;
import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Message;
import com.mftplus.demo.model.service.MessageService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/messages")
@Slf4j

public class MessageApi {
    @Inject
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getAllMessages() {
        log.info("All Messages :");
        return messageService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getMessageById(@PathParam("id") Long id) {
        log.info("Get Message by id : {}", id);
        return messageService.findById(id);
    }

    @GET
    @Path("/title/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getMessageByTitle(@PathParam("title") String title) {
        log.info("Get Message by title : {}", title);
        return messageService.findByTitle(title);
    }

    @GET
    @Path("/text/{text}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getMessageByText(@PathParam("text") String text) {
        log.info("Get Message by text : {}", text);
        return messageService.findByText(text);
    }

    @GET
    @Path("/username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getMessageByUsername(@PathParam("username") String username) {
        log.info("Get Message by Username : {}", username);
        return messageService.findByUsername(username);
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getMessageByUserEmail(@PathParam("email") String email) {
        log.info("Get Message by Email : {}", email);
        return messageService.findByUserEmail(email);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object createMessage(@Valid Message message) {
        log.info("Create Message : {}", message);
        messageService.save(message);
        return message;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object updateMessage(@Valid Message message) {
        log.info("Update Message : {}", message);
        messageService.edit(message);
        return message;
    }

    @DELETE
    @Path("{id}")
    public Response deleteMessage(@PathParam("id") Long id) {
        log.info("Delete Message : {}", id);
        messageService.remove(id);
        return Response.ok().entity(id).build();
    }
}
