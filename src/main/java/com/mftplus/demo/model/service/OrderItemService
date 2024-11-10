package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.OrderItem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@Slf4j
public class OrderItemService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(OrderItem orderItem) {
        entityManager.persist(orderItem);
    }

    @Transactional
    public void edit(OrderItem orderItem) {
        entityManager.merge(orderItem);
    }

    @Transactional
    public void remove(Long id) {
        OrderItem orderItem = entityManager.find(OrderItem.class, id);
        entityManager.remove(orderItem);
    }

    @Transactional
    public OrderItem findById(Long id) {
        return entityManager.find(OrderItem.class, id);
    }

    @Transactional
    public List<OrderItem> findAll(){
        Query query = entityManager.createQuery("SELECT o FROM OrderItem o", OrderItem.class);
        return query.getResultList();
    }

    @Transactional
    public List<OrderItem> findByProductId(Long orderId) {
        Query query = entityManager.createQuery("SELECT o FROM OrderItem o WHERE o.productId = :productId", OrderItem.class);
    }

}
