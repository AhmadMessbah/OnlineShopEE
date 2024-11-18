package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Payment;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
@Loggable
@Slf4j
public class PaymentService implements Service<Payment, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Payment payment) {
        entityManager.persist(payment);
    }

    @Transactional
    @Override
    public void edit(Payment payment) {
        entityManager.merge(payment);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Payment payment = entityManager.find(Payment.class, id);
        entityManager.remove(payment);
    }

    @Transactional
    @Override
    public Payment findById(Long id) {
        return entityManager.find(Payment.class, id);
    }

    @Transactional
    @Override
    public List<Payment> findAll() {
        Query query = entityManager.createQuery("select p from paymentEntity p", Payment.class);
        return query.getResultList();
    }

    @Transactional
    public List<Payment> findByDate(LocalDate date) {
        Query query = entityManager.createQuery("select p from paymentEntity p where p.date = :date", Payment.class);
        query.setParameter("date", date);
        return query.getResultList();
    }
}
