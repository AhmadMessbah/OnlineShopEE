package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.*;
import com.mftplus.demo.model.service.ProductService;
import com.mftplus.demo.model.service.TicketService;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;
import java.util.Set;

@Path("/test")
@Loggable
public class TestApiM {

    @Inject
    private ProductService productService;

    @Inject
    private TicketService ticketService;

    @GET
    public String test() {

//        while (t.getParent() != null) {
//            System.out.println("ticket group parent: " + t.getParent().getName());
//        }

        Permission permission = Permission.builder().permissionName("get").build();
        Role role = Role.builder().permissionSet(Set.of(permission)).roleName("admin").build();
        User user = User.builder().username("eeee").password("234").roleList(List.of(role)).build();
        Person person = Person.builder().name("aas").family("ass").user(user).build();
        Message message = Message.builder().text("helloooo").title("say-hello").user(user).build();
        TicketGroup child = new TicketGroup();
        TicketGroup parent = new TicketGroup();
        child.setName("digital");
        parent.setName("electronic");
        TicketGroup ticketGroup = TicketGroup.builder().name("mobile").parent(parent).build();
        Ticket ticket = Ticket.builder().messages(List.of(message)).ticketGroup(ticketGroup).title("buy").user(user).responseType("delivered").text("this is your order").build();
        ticketService.save(ticket);
//        personService.save(person);
        ProductGroup child1 = new ProductGroup();
        ProductGroup parent2 = new ProductGroup();
        child.setName("digital");
        parent.setName("electronic");
        ProductPropertyValue productPropertyValue= ProductPropertyValue.builder().name("64G").build();
        GroupProperty groupProperty = GroupProperty.builder().name("ram").productPropertyValue(productPropertyValue).build();
        ProductGroup productGroup =ProductGroup.builder().groupProperty(groupProperty).name("laptop").parent(parent2).build();
        Product product =Product.builder()
                .name("laptop")
                .price(20F)
                .productGroup(productGroup)
                .code(1L)
                .build();
        productService.save(product);
//        return ticket.toString();
        return product.toString();


    }
}
