package com.mftplus.demo.controller.api;
import com.mftplus.demo.model.entity.*;
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
//    private MessageService messageService;
//    private PersonService personService;
    private TicketService ticketService;
//    private UserService userService;

    @GET
//    @ResponseMaker(authority = "SAVE_USER")
    public String test() {
//        Person person=Person.builder().name("aas").family("ass").build();


//        User user = User.builder().username("mobi").build();
//        TicketGroup t = new TicketGroup();
//        userService.save(user);
//        while (t.getParent() != null) {
//            System.out.println("ticket group parent: " + t.getParent().getName());
//        }
//        return user.toString();

//        Message message=Message.builder().text("helloooo").build();
//        messageService.save(message);
//        return message.toString();

//        User user=User.builder().username("mmm").build();
//        userService.save(user);
//        return user.toString();
//        Person person=Person.builder().name("mobina").build();
//        personService.save(person);
//        return person.toString();

                //DO
        TicketGroup child=new TicketGroup();
        TicketGroup parent=new TicketGroup();
        child.setName("digital");
        parent.setName("electronic");
        TicketGroup ticketGroup=TicketGroup.builder().name("mobile").parent(parent).build();

        Permission permission = Permission.builder().permissionName("get").build();
        Role role = Role.builder().permissionSet(Set.of(permission)).roleName("admin").build();
        User user=User.builder().username("eeee").password("234").roleList(List.of(role)).build();
//        Person person=Person.builder().name("aas").family("ass").user(user).build();

        Message message = Message.builder().user(user).title("security requirement").text("please check").dateTime("2024.01.23").build();
        Ticket ticket=Ticket.builder().messages(List.of(message)).ticketGroup(ticketGroup).title("buy").text("this is your order").build();

//        TicketGroup t =new TicketGroup();
//        while (t.getParent() !=null){
//            System.out.println(parent.getChildList());
//
//        }
        ticketService.save(ticket);
        return ticket.toString();
//        userService.save(user);
//        return user.toString();
//        personService.save(person);
//        return person.toString();

    }
}
