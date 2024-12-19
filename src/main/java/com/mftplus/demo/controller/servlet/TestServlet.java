package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.entity.enums.Gender;
import com.mftplus.demo.model.service.PersonService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@WebServlet(urlPatterns = "/test")
@Slf4j
public class TestServlet extends HttpServlet {
    @Inject
    private PersonService personService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
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
                    .user(User.builder().roleSet(Set.of(role)).username("sara").password("sara123").build())
                    .build();
            personService.save(person);
            log.info(person.getName() + " Saved");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
