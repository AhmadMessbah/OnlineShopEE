package com.mftplus.demo.controller.api;

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
    public Response getAllTicketGroups() {
        log.info("All TicketGroups :");
        return Response.ok().entity(ticketGroupService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketGroupById(@PathParam("id") Long id) {
        log.info("Get TicketGroup by id : {}", id);
        return Response.ok().entity(ticketGroupService.findById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTicketGroup(@Valid TicketGroup ticketGroup) {
        log.info("Create TicketGroup : {}", ticketGroup);
        ticketGroupService.save(ticketGroup);
        return Response.ok().entity(ticketGroup).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTicketGroup(@Valid TicketGroup ticketGroup) {
        log.info("Update TicketGroup : {}", ticketGroup);
        ticketGroupService.edit(ticketGroup);
        return Response.ok().entity(ticketGroup).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteTicketGroup(@PathParam("id") Long id) {
        log.info("Delete ticketGroupGroupGroup : {}", id);
        ticketGroupService.remove(id);
        return Response.ok().entity(id).build();
    }

}
