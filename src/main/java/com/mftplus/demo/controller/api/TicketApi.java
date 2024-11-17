package com.mftplus.demo.controller.api;


import com.mftplus.demo.model.entity.Ticket;
import com.mftplus.demo.model.service.TicketService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/tickets")
@Loggable
@Slf4j
public class TicketApi {
    @Inject
    private TicketService ticketService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTickets() {
        log.info("All Tickets :");
        return Response.ok().entity(ticketService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketById(@PathParam("id") Long id) {
        log.info("Get Ticket by id : {}", id);
        return Response.ok().entity(ticketService.findById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTicket(@Valid Ticket ticket) {
        log.info("Create Ticket : {}", ticket);
        ticketService.save(ticket);
        return Response.ok().entity(ticket).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTicket(@Valid Ticket ticket) {
        log.info("Update Ticket : {}", ticket);
        ticketService.edit(ticket);
        return Response.ok().entity(ticket).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteTicket(@PathParam("id") Long id) {
        log.info("Delete Ticket : {}", id);
        ticketService.remove(id);
        return Response.ok().entity(id).build();
    }

}
