package com.mftplus.demo.controller.servlet;

import com.mftplus.demo.model.entity.*;
import com.mftplus.demo.model.entity.enums.Gender;
import com.mftplus.demo.model.service.PersonService;
import com.mftplus.demo.model.service.ProductService;
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
    private ProductService productService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            ProductGroup child = new ProductGroup();
            ProductGroup parent = new ProductGroup();
            child.setName("digital");
            parent.setName("electronic");
            ProductPropertyValue propertyValue = ProductPropertyValue.builder().name("64G").build();
            GroupProperty groupProperty = GroupProperty.builder().name("ram").productPropertyValue(propertyValue).build();
            ProductGroup productGroup = ProductGroup.builder().groupProperty(groupProperty).name("laptop").parent(parent).build();
            Product product = Product.builder().name("laptop").price(20F).productGroup(productGroup).code(1L).build();
            productService.save(product);
            log.info("product saved" + product);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
//    }
//            Role role = Role.builder().roleName("admin").build();
//
//            Person person = Person.builder()
//                    .gender(Gender.Female)
//                    .name("sara")
//                    .family("rezaei")
//                    .postalCode("1234")
//                    .phoneNumber("09123223445")
//                    .nationalId("1234456")
//                    .birthDate(LocalDate.of(1995, 2, 3))
//                    .address("Tehran_west")
//                    .user(User.builder().roleSet(Set.of(role)).username("sara").password("sara123").build())
//                    .build();
//            personService.save(person);
//            log.info(person.getName() + " Saved");
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
}
