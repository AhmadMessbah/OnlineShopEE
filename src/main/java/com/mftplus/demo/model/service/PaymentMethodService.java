package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.PaymentMethod;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PaymentMethodService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(PaymentMethod paymentMethod) {
        entityManager.persist(paymentMethod);
    }

    @Transactional
    public void edit(PaymentMethod paymentMethod) {
        entityManager.merge(paymentMethod);
    }

    @Transactional
    public void remove(Integer id) {
        PaymentMethod paymentMethod = entityManager.find(PaymentMethod.class, id);
        entityManager.remove(paymentMethod);
    }

    @Transactional
    public List<PaymentMethod> findAll() {
        Query query = entityManager.createQuery("select p from PaymentMethod p", PaymentMethod.class);
        return query.getResultList();
    }

    @Transactional
    public PaymentMethod findById(Integer id) {
        return entityManager.find(PaymentMethod.class, id);
    }
}
