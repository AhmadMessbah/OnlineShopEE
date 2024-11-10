package com.mftplus.demo.controller.api;


import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.service.ProductService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/products")
@Slf4j
public class productApi {
    @Inject
    private ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Response getProducts() {
        log.info("getProducts +");
        return Response.ok().entity(productService.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") Long id) {
        log.info("getProduct By Id +");
        return Response.ok().entity(productService.findById(id)).build();
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductByName(@PathParam("name") String name) {

        log.info("getProductByName +");
        return Response.ok().entity(productService.findByName(name)).build();

    }

    @GET
    @Path("/price/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductByPrice(@PathParam("price") Float price) {
        log.info("getProductByPrice +");
        return Response.ok().entity(productService.findByPrice(price)).build();
    }

    @GET
    @Path("/code/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductByCode(@PathParam("code") Long code) {
        log.info("getProductByCode +");
        return Response.ok().entity(productService.findByCode(code)).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(@Valid Product product) {
        log.info("add Product +");
        productService.save(product);
        return Response.ok().entity(product).build();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@Valid Product product) {
        log.info("update Product +");
        productService.edit(product);
        return Response.ok().entity(product).build();

    }

    @DELETE
    @Path("{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        log.info("deleteProduct +");
       productService.remove(id);
       return Response.ok().entity(id).build();
    }

}
