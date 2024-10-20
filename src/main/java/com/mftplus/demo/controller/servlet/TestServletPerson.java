package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.entity.enums.Gender;
import com.mftplus.demo.model.service.PersonService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/testPerson", loadOnStartup = 1)

public class TestServletPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        Role role = Role.builder().roleName("admin").build();

        Person person = Person.builder()
                .gender(Gender.Female)
                .name("sara")
                .family("rezaei")
                .postalCode("1234")
                .phoneNumber("09123223445")
                .nationalId("1234456")
                .birthDate(LocalDate.of(1995, 2, 3))
                .address("Tehran_west")
                .user(User.builder().roleList(List.of(role)).username("sara123").build())
                .build();

        try {
            PersonService.getPersonService().save(person);
            System.out.println(person);
        } catch (Exception e) {
            System.out.println("Error Person Loading..." + e.getMessage());
        }
    }
}
