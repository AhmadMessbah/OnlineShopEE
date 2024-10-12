package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.entity.enums.Gender;
import com.mftplus.demo.model.service.PersonService;

import java.time.LocalDate;

public class PersonTest {

    public static void main(String[] args) throws Exception {

//        User user= User.builder()
//                .username("moones")
//                .password("mooo")
//                .email("mmmm@gmail.com")
//                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezaei")
                .address("tehran_north")
                .birthDate(LocalDate.of(2011, 12, 3))
                .nationalId("123456")
                .phoneNumber("0912765432")
                .postalCode("123456")
                .gender(Gender.Male)
                .build();
//        PersonService.getPersonService().remove(1L);
//        System.out.println("person removed!!"+person.getId());


        //  person.setUser(user);
        //  PersonService.save(person);

        //     person.setUser(user);
        //     PersonService.getPersonService().save(person);
        //     System.out.println(PersonService.getPersonService().findById(1L));
        //     PersonService.getPersonService().findByAddress("tehran");
        //     PersonService.getPersonService().findByNationalId("12");
        //     PersonService.getPersonService().findByPhoneNumber("09");
        //     PersonService.getPersonService().findByLastNameOrFirstName("reza","");
        //     PersonService.getPersonService().findByPostalCode("1");
        //     System.out.println(person.getPostalCode());
        //     System.out.println("Person Saved :"+person);
        //   System.out.println(person);
        //   System.out.println("removed"+person.getId());
    }
}
