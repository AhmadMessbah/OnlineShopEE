package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.FinancialDoc;
import com.mftplus.demo.model.service.FinancialDocService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
@Path("/financial-docs")
public class FinancialDocApi {

    @Inject
    private FinancialDocService financialDocService;

    @Inject
    private Validator validator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFinancialDoc(@Valid FinancialDoc financialDoc) {
        try {
            Set<ConstraintViolation<FinancialDoc>> violations = validator.validate(financialDoc);

            if (!violations.isEmpty()) {
                String errorMessage = violations.stream()
                        .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                        .collect(Collectors.joining(", "));

                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"errors\": \"" + errorMessage + "\"}")
                        .build();
            }

            financialDocService.save(financialDoc);
            return Response.status(Response.Status.CREATED)
                    .entity("{\"message\": \"Financial Document created successfully!\"}")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"errors\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }
}
