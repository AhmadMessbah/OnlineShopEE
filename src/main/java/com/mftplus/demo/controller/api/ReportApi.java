package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Report;
import com.mftplus.demo.model.service.ReportService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/reports")
@Slf4j
public class ReportApi {

    @Inject
    private ReportService reportService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReports() {
        log.info("Getting all reports");
        return Response.ok().entity(reportService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getReportById(@PathParam("id") Integer id) {
        Report report = reportService.findById(id);
        if (report == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Report not found").build();
        }
        return Response.ok().entity(report).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReport(Report report) {
        reportService.save(report);
        return Response.status(Response.Status.CREATED).entity(report).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateReport(Report report) {
        reportService.edit(report);
        return Response.ok().entity(report).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteReport(@PathParam("id") Integer id) {
        reportService.remove(id);
        return Response.ok().entity(id).build();
    }
}
