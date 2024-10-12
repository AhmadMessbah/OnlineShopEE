package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class PersonService implements Service<Person, Long> {
    @Getter
    private static PersonService personService = new PersonService();

    private PersonService() {
    }

    @Override
    public void save(Person person) throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(person);
        }
    }

    @Override
    public void edit(Person person) throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(person);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Person.class);
        }
    }

    @Override
    public Person findById(Long id) throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Person.class);
        }
    }

    @Override
    public List<Person> findAll() throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Person.class);
        }
    }

    public List<Person> findByNationalId(String nationalId) throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("nationalId", nationalId + "%");
            return crudRepository.findBy("Person.findByNationalId", params, Person.class);
        }
    }

    public List<Person> findByLastNameOrFirstName(String name, String family) throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("name", name + "%");
            params.put("family", family + "%");
            List<Person> personList = crudRepository.findBy("Person.findByLastNameOrFirstName", params, Person.class);
            return (personList.isEmpty()) ? null : personList;
        }
    }

    public List<Person> findByPhoneNumber(String phoneNumber) throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("phoneNumber", phoneNumber + "%");
            return crudRepository.findBy("Person.findByPhoneNumber", params, Person.class);
        }
    }

    public List<Person> findByPostalCode(String postalCode) throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("postalCode", postalCode + "%");
            return crudRepository.findBy("Person.findByPostalCode", params, Person.class);
        }
    }

    public List<Person> findByAddress(String address) throws Exception {
        try (CrudRepository<Person, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("address", address + "%");
            return crudRepository.findBy("Person.findByAddress", params, Person.class);
        }
    }
}
