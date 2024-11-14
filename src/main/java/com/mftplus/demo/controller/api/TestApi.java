package com.mftplus.demo.controller.api;
//todo->test program

import com.mftplus.demo.model.entity.*;
import com.mftplus.demo.model.entity.enums.Gender;
import com.mftplus.demo.model.entity.enums.OrderStatus;
import com.mftplus.demo.model.service.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.mftplus.demo.model.entity.enums.DeliveryMethod.standardShipping;

@Path("/test")
@Slf4j
public class TestApi {

//    @Inject
//    private InventoryService inventoryService;

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response test () throws Exception {
//        Inventory inventory = Inventory.builder().title("aaa").phone("2145").address("5sdfgea5").build();
//        inventoryService.save(inventory);
//        log.info("inventory saved");
//        return Response.status(Response.Status.CREATED).entity(inventory).build();
//    }

//    @Inject
//    private BankService bankService;
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response test () throws Exception {
//        Bank bank = Bank.builder().id(1L).name("Sample Bank").accountNumber("1234567890").build();
//        bankService.save(bank);
//        log.info("bank saved");
//        return Response.status(Response.Status.CREATED).entity(bank).build();
//    }

//    @Inject
//    private PersonService personService;
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response test () throws Exception {
//
//        Role role1=Role.builder().roleName("admin").build();
//        Role role2=Role.builder().roleName("seller").build();
//
//        User user1= User.builder()
//                .username("moones")
//                .password("mooo")
//                .email("mmmm@gmail.com")
//                .roleList(List.of(role1,role2))
//                .build();
//        User user2= User.builder()
//                .username("momo")
//                .password("mo122")
//                .email("mooo@gmail.com")
//                .build();
//        Person person = Person.builder()
//                .name("mobina")
//                .family("azimi")
//                .address("tehran_north")
//                .birthDate(LocalDate.of(2011, 12, 3))
//                .nationalId("123456")
//                .phoneNumber("0912765432")
//                .postalCode("123456")
//                .user(user1)
//                .user(user2) //TODO:faghat yek user save mishe pls check
//                .gender(Gender.Female)
//                .build();
//        personService.save(person);
//        log.info("inventory saved");
//        return Response.status(Response.Status.CREATED).entity(person).build();
//    }

//
//    @Inject
//    DeliveryService deliveryService;
//    @GET
//
//    public String test (){
//        Delivery delivery = Delivery
//                .builder()
//                .deliveryAddress("Tehran")
//                .deliveryMethod(standardShipping)
//                .carrier("Method")
//                .trackingNumber("8998")
//                .deliveredDate(LocalDateTime.now())
//                .build();
//        deliveryService.save(delivery);
//        log.info("delivery saved");
//        return delivery.toString();
//    }

    @Inject
    OrderService orderService;
    @GET

    public String test(){
        Order order = Order
                .builder().tax(5642).billingAddress("KKKK").createdAt(LocalDateTime.now()).shippingCost(3524).totalAmount(65).discount(56).orderDate(LocalDateTime.now()).updatedAt(LocalDateTime.now()).orderStatus(OrderStatus.PENDING).build();
        orderService.save(order);
        log.info("order saved");
        return order.toString();
    }



}