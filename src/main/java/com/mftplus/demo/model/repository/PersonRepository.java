package com.mftplus.demo.model.repository;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class PersonRepository implements AutoCloseable {

    private EntityManager entityManager;

    public void save(Person person) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(person);
        transaction.commit();
    }

    public void edit(Person person) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(person);
        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
        transaction.commit();
    }

    public Person findById(Long id) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Person.class, id);
    }

//    public List<Person> findAll() {}

    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
