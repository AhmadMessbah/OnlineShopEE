package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TransactionService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(Transaction transaction) {
        entityManager.persist(transaction);
    }

    @Transactional
    public void edit(Transaction transaction) {
        entityManager.merge(transaction);
    }

    @Transactional
    public void remove(Integer id) {
        Transaction transaction = entityManager.find(Transaction.class, id);
        entityManager.remove(transaction);
    }

    @Transactional
    public List<Transaction> findAll() {
        Query query = entityManager.createQuery("select t from TransactionEntity t", Transaction.class);
        return query.getResultList();
    }

    @Transactional
    public Transaction findById(Integer id) {
        return entityManager.find(Transaction.class, id);
    }
}
