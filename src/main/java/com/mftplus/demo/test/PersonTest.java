package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.entity.enums.Gender;
import com.mftplus.demo.model.service.PersonService;
import com.mftplus.demo.model.service.UserService;

import java.time.LocalDate;
import java.util.List;

public class PersonTest {

    public static void main(String[] args) throws Exception {
        Role role1=Role.builder().roleName("admin").build();
        Role role2=Role.builder().roleName("seller").build();


        User user1= User.builder()
                .username("moones")
                .password("mooo")
                .email("mmmm@gmail.com")
                .roleList(List.of(role1,role2))
                .build();
        User user2= User.builder()
                .username("momo")
                .password("mo122")
                .email("mooo@gmail.com")
                .build();

        Person person = Person.builder()
                .name("mobina")
                .family("azimi")
                .address("tehran_north")
                .birthDate(LocalDate.of(2011, 12, 3))
                .nationalId("123456")
                .phoneNumber("0912765432")
                .postalCode("123456")
                .user(user1)
                .user(user2) //TODO:faghat yek user save mishe pls check
                .gender(Gender.Female)
                .build();

       PersonService.getPersonService().save(person);
        System.out.println(person);
//        person.setUser(user2);
//        PersonService.getPersonService().save(person);
//        System.out.println(person);
//        PersonService.getPersonService().remove(1L);
//        System.out.println("person removed!!"+person.getId());


   //       PersonService.getPersonService().save(person);

//            person.setUser(user);
   //          PersonService.getPersonService().save(person);
        //     System.out.println(PersonService.getPersonService().findById(1L));
        //     PersonService.getPersonService().findByAddress("tehran");
        //     PersonService.getPersonService().findByNationalId("12");
    //    System.out.println(PersonService.getPersonService().findByPhoneNumber("09"));
   //     System.out.println(PersonService.getPersonService().findByLastNameAndFirstName("mobina","hoseini"));
        //     PersonService.getPersonService().findByPostalCode("1");
        //     System.out.println(person.getPostalCode());
    //    System.out.println(PersonService.getPersonService().findByUsername("momo").getPhoneNumber());

        //    System.out.println("Person username:"+person);
    //        System.out.println(person);
        //     System.out.println("removed"+person.getId());
    }
}
