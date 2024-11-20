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

    @GET
    @Path("/title/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketByTitle(@PathParam("title") String title) {
        log.info("Get Ticket by title : {}", title);
        return Response.ok().entity(ticketService.findByTitle(title)).build();
    }

    @GET
    @Path("/text/{text}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketByText(@PathParam("text") String text) {
        log.info("Get Ticket by text : {}", text);
        return Response.ok().entity(ticketService.findByText(text)).build();
    }

    @GET
    @Path("/response/{response}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketByRespType(@PathParam("response") String responseType) {
        log.info("Get Ticket by response type : {}", responseType);
        return Response.ok().entity(ticketService.findByResponseType(responseType)).build();
    }

    @GET
    @Path("/username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketByUsername(@PathParam("username") String username) {
        log.info("Get Ticket by username : {}", username);
        return Response.ok().entity(ticketService.findByUsername(username)).build();
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketByUserEmail(@PathParam("email") String email) {
        log.info("Get Ticket by Email : {}", email);
        return Response.ok().entity(ticketService.findByUserEmail(email)).build();
    }

    @GET
    @Path("/mTitle/{mTitle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketByMessageTitle(@PathParam("mTitle") String title) {
        log.info("Get Ticket by Message Title : {}", title);
        return Response.ok().entity(ticketService.findByMessageTitle(title)).build();
    }

    @GET
    @Path("/mText/{mText}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketByMessageText(@PathParam("mText") String text) {
        log.info("Get Ticket by Message Text : {}", text);
        return Response.ok().entity(ticketService.findByMessageText(text)).build();
    }

    @GET
    @Path("/groupName/{groupName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketByGroupName(@PathParam("groupName") String name) {
        log.info("Get Ticket by Group Name : {}", name);
        return Response.ok().entity(ticketService.findByTicketGroupName(name)).build();
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
