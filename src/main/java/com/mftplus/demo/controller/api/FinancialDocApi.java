package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.FinancialDoc;
import com.mftplus.demo.model.service.FinancialDocService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/financial-docs")
@Slf4j
public class FinancialDocApi {

    @Inject
    private FinancialDocService financialDocService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFinancialDocs() {
        log.info("Getting all financial documents");
        return Response.ok().entity(financialDocService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getFinancialDocById(@PathParam("id") Integer id) {
        FinancialDoc financialDoc = financialDocService.findById(id);
        if (financialDoc == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Financial document not found").build();
        }
        return Response.ok().entity(financialDoc).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFinancialDoc(FinancialDoc financialDoc) {
        financialDocService.save(financialDoc);
        return Response.status(Response.Status.CREATED).entity(financialDoc).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFinancialDoc(FinancialDoc financialDoc) {
        financialDocService.edit(financialDoc);
        return Response.ok().entity(financialDoc).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteFinancialDoc(@PathParam("id") Integer id) {
        financialDocService.remove(id);
        return Response.ok().entity(id).build();
    }
}
