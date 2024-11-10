package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Bank;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BankService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(Bank bank) {
        entityManager.persist(bank);
    }

    @Transactional
    public void edit(Bank bank) {
        entityManager.merge(bank);
    }

    @Transactional
    public void remove(Long id) {
        Bank bank = entityManager.find(Bank.class, id);
        entityManager.remove(bank);
    }

    @Transactional
    public List<Bank> findAll() {
        Query query = entityManager.createQuery("select b from BankEntity b", Bank.class);
        return query.getResultList();
    }

    @Transactional
    public Bank findById(Long id) {
        return entityManager.find(Bank.class, id);
    }
}
