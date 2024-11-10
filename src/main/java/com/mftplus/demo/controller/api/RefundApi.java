package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Refund;
import com.mftplus.demo.model.service.RefundService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/refunds")
@Slf4j
public class RefundApi {

    @Inject
    private RefundService refundService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRefunds() {
        log.info("Getting all refunds");
        return Response.ok().entity(refundService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getRefundById(@PathParam("id") Long id) {
        Refund refund = refundService.findById(id);
        if (refund == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Refund not found").build();
        }
        return Response.ok().entity(refund).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRefund(Refund refund) {
        refundService.save(refund);
        return Response.status(Response.Status.CREATED).entity(refund).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRefund(Refund refund) {
        refundService.edit(refund);
        return Response.ok().entity(refund).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteRefund(@PathParam("id") Long id) {
        refundService.remove(id);
        return Response.ok().entity(id).build();
    }
}
