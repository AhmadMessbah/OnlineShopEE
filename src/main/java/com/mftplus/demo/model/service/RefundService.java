package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Refund;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RefundService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(Refund refund) {
        entityManager.persist(refund);
    }

    @Transactional
    public void edit(Refund refund) {
        entityManager.merge(refund);
    }

    @Transactional
    public void remove(Integer id) {
        Refund refund = entityManager.find(Refund.class, id);
        entityManager.remove(refund);
    }

    @Transactional
    public List<Refund> findAll() {
        Query query = entityManager.createQuery("select r from RefundEntity r", Refund.class);
        return query.getResultList();
    }

    @Transactional
    public Refund findById(Integer id) {
        return entityManager.find(Refund.class, id);
    }
}
