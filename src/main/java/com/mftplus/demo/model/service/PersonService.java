package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.repository.PersonRepository;

public class PersonService {
    public static void save(Person person) throws Exception {

        try (PersonRepository personRepository = new PersonRepository()) {
            personRepository.save(person);
        }
    }
    public static void edit(Person person) throws Exception {

        try (PersonRepository personRepository = new PersonRepository()) {
            personRepository.edit(person);
        }
    }
}
