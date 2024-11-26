package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.Loggable;
import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.TicketGroup;
import com.mftplus.demo.model.service.TicketGroupService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/groups")
@Slf4j
public class TicketGroupApi {
    @Inject
    private TicketGroupService ticketGroupService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getAllTicketGroups() {
        log.info("All TicketGroups :");
        return ticketGroupService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getTicketGroupById(@PathParam("id") Long id) {
        log.info("Get TicketGroup by id : {}", id);
        return ticketGroupService.findById(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getTicketGroupByName(@PathParam("name") String name) {
        log.info("Get TicketGroup by name : {}", name);
        return ticketGroupService.findByName(name);
    }

    @GET
    @Path("/parent/{parent}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object getTicketGroupByParent(@PathParam("parent") String name) {
        log.info("Get TicketGroup by parent : {}", name);
        return ticketGroupService.findByParent(name);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object createTicketGroup(@Valid TicketGroup ticketGroup) {
        log.info("Create TicketGroup : {}", ticketGroup);
        ticketGroupService.save(ticketGroup);
        return ticketGroup;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Loggable
    @ResponseMaker
    public Object updateTicketGroup(@Valid TicketGroup ticketGroup) {
        log.info("Update TicketGroup : {}", ticketGroup);
        ticketGroupService.edit(ticketGroup);
        return ticketGroup;
//        ticketGroupService.edit(ticketGroup);
//        return Response.ok().entity(ticketGroup).build();
    }

    @DELETE
    @Path("{id}")
                    //todo
    public Response deleteTicketGroup(@PathParam("id") Long id) {
        log.info("Delete ticketGroupGroupGroup : {}", id);
        ticketGroupService.remove(id);
        return Response.ok().entity(id).build();
    }
}
