package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequestScoped
@Loggable
@Slf4j
public class PersonService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    public void edit(Person person) {
        entityManager.merge(person);
    }

    @Transactional
    public Person remove(Long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
        return person;
    }

    @Transactional
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Transactional
    public List<Person> findAll() {
        Query query = entityManager.createQuery("select p from personEntity p", Person.class);
        return query.getResultList();
    }

    @Transactional
    public List<Person> findByNationalId(String nationalId) {
        Query query = entityManager.createQuery("select p from personEntity p where p.nationalId = :nationalId", Person.class);
        query.setParameter("nationalId", nationalId);
        return query.getResultList();
    }

    @Transactional
    public List<Person> findByName(String name) {
        Query query = entityManager.createQuery("select p from personEntity p where p.name like :name", Person.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Transactional
    public List<Person> findByFirstNameAndLastName(String name, String family) {
        Query query = entityManager.createQuery("select p from  personEntity p where p.name = : name and p.family = : family", Person.class);
        query.setParameter("name", name);
        query.setParameter("family", family);
        return query.getResultList();
    }

    @Transactional
    public Person findByUsernameAndPassword(String username, String password) {
//        if (userService.findByUsernameAndPassword(username, password) != null) {
        Query query = entityManager.createQuery("select p from  personEntity p where p.user.username = : username and p.user.password = : password", Person.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (Person) query.getSingleResult();
//        }else {
//            throw new NoPersonException();
//        }
    }

    @Transactional
    public Person findByUsername(String username) {
//        if (userService.findByUsername(username) != null ) {
        Query query = entityManager.createQuery("select p from  personEntity p where p.user.username = :username", Person.class);
        query.setParameter("username", username);
        return (Person) query.getSingleResult();
//        } else {
//            throw new NoPersonException();
//        }
    }

    @Transactional
    public List<Person> findByPhoneNumber(String phoneNumber) {
        Query query = entityManager.createQuery("select p from  personEntity p where p.phoneNumber = :phoneNumber", Person.class);
        query.setParameter("phoneNumber", phoneNumber);
        return query.getResultList();

    }

    @Transactional
    public List<Person> findByPostalCode(String postalCode) {
        Query query = entityManager.createQuery("select p from personEntity p where p.postalCode = :postalCode", Person.class);
        query.setParameter("postalCode", postalCode);
        return query.getResultList();
    }

    @Transactional
    public List<Person> findByAddress(String address) {
        Query query = entityManager.createQuery("select p from personEntity p where p.address = :address", Person.class);
        query.setParameter("address", address);
        return query.getResultList();
    }
}
