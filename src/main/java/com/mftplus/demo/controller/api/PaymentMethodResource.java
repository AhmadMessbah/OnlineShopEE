package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.PaymentMethod;
import com.mftplus.demo.model.service.PaymentMethodService;
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
@Path("/payment-methods")
public class PaymentMethodResource {

    @Inject
    private PaymentMethodService paymentMethodService;

    @Inject
    private Validator validator;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPaymentMethod(@Valid PaymentMethod paymentMethod) {
        try {
            Set<ConstraintViolation<PaymentMethod>> violations = validator.validate(paymentMethod);

            if (!violations.isEmpty()) {
                String errorMessage = violations.stream()
                        .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                        .collect(Collectors.joining(", "));

                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"errors\": \"" + errorMessage + "\"}")
                        .build();
            }

            paymentMethodService.save(paymentMethod);
            return Response.status(Response.Status.CREATED)
                    .entity("{\"message\": \"Payment Method created successfully!\"}")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"errors\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }
}
