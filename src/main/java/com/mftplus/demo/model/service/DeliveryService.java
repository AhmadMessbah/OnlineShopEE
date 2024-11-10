package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Delivery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@Slf4j

public class DeliveryService implements Service<Delivery, Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Delivery delivery){
        entityManager.persist(delivery);
    }
    @Transactional
    @Override
    public void edit(Delivery delivery){
        entityManager.merge(delivery);
    }

    @Transactional
    @Override
    public void remove(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }
    @Transactional
    @Override
    public List<Delivery> findAll(){
        Query query = entityManager.createQuery("select d from Delivery d", Delivery.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public Delivery findByTrackingNumber(String trackingNumber){
        Query query = entityManager.createQuery("select d from Delivery d where d.trackingNumber = :trackingNumber", Delivery.class);
        query.setParameter("trackingNumber", trackingNumber);
        return (Delivery) query.getSingleResult();
    }
    @Transactional
    @Override
    public List<Delivery> findByDeliveryAddress(String deliveryAddress){
        Query query = entityManager.createQuery("select d from Delivery d. where d.deliveryAddress = :deliveryAddress", Delivery.class);
        query.setParameter("deliveryAddress", deliveryAddress);
        return query.getResultList();
    }

}
