package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.entity.enums.Gender;
import com.mftplus.demo.model.repository.PersonRepository;
import com.mftplus.demo.model.repository.UserRepository;
import com.mftplus.demo.model.service.PersonService;
import com.mftplus.demo.model.service.UserService;

import java.time.LocalDate;

public class PersonTest {

    public static void main(String[] args) throws Exception {

        User user= User.builder()
                .username("moones")
                .password("mooo")
                .email("mmmm@gmail.com")
                .build();

        Person person = Person.builder()
                .name("ali")
                .family("alipor")
                .address("asdfghjukjhgfdsdfvg")
                .birthDate(LocalDate.of(2000, 12, 3))
                .nationalId("123456")
                .phoneNumber("098765432")
                .postalCode("123456")
                .gender(Gender.Male)
                .build();
  //      UserRepository userRepository = new UserRepository();
        PersonRepository personRepository=new PersonRepository();
//        userRepository.save(user);
//        person.setUser(user);
      //  PersonService.save(person);
  //     personRepository.save(person);
      personRepository.findById(1L); //todo (worked this)
 //     personRepository.remove(1L);

     //   System.out.println(person);
   //     System.out.println("removed"+person.getId());
    }
}
