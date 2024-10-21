package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Order;
import com.mftplus.demo.model.entity.enums.OrderStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@Slf4j
public class OrderService implements Service<Order, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Transactional
    @Override
    public void edit(Order order) {
        entityManager.merge(order);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Order order = entityManager.find(Order.class, id);
        entityManager.remove(order);
    }

    @Transactional
    @Override
    public Order findById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Transactional
    @Override
    public List<Order> findAll() {
        Query query = entityManager.createQuery("select o from OrderEntity o", Order.class);
        return query.getResultList();
    }

    @Transactional
    public Order findByCustomerId(Long id) {
        Query query = entityManager.createQuery("select o from OrderEntity o where o.user.id = :userId", Order.class);
        query.setParameter("userId", id);
        return (Order) query.getSingleResult();
    }
    @Transactional
    public Order findByOrderStatus(OrderStatus orderStatus) {
        Query query = entityManager.createQuery("select o from OrderEntity o where o.orderStatus = :orderStatus", Order.class);
        query.setParameter("orderStatus", orderStatus);
        return (Order) query.getSingleResult();
    }

    @Transactional
    public List<Order> findByBillingAddress(String billingAddress) {
        Query query = entityManager.createQuery("select o from OrderEntity o where o.billingAddress = :billingAddress", Order.class);
        query.setParameter("billingAddress", billingAddress);
        return query.getResultList();
    }
}
