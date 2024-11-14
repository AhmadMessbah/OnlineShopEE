package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Inventory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@ApplicationScoped
@Slf4j
public class InventoryService {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(Inventory inventory) {
        entityManager.persist(inventory);
    }

    @Transactional
    public void edit(Inventory inventory) {
        entityManager.merge(inventory);
    }

    @Transactional
    public void remove(Long id) {
        Inventory inventory = entityManager.find(Inventory.class, id);
        entityManager.remove(inventory);
    }

    @Transactional
    public Inventory findById(Long id) {
        return entityManager.find(Inventory.class, id);
    }

    @Transactional
    public List<Inventory> findAll() {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo", Inventory.class);
        return query.getResultList();
    }

    @Transactional
    public List<Inventory> findByTitle(String title) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo where oo.title = :title", Inventory.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Transactional
    public List<Inventory> findByAddress(String address) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo where oo.address = :address", Inventory.class);
        query.setParameter("address", address);

        return query.getResultList();
    }

    @Transactional
    public List<Inventory> findByPhone(String phone) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo where oo.phone = :phone", Inventory.class);
        query.setParameter("phone", phone);
        return query.getResultList();
    }

    @Transactional
    public Inventory findByTransactionId(Long id) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo cross join inventoryTransactionEntity i where i.id=:id", Inventory.class);
        query.setParameter("id", id);
        return (Inventory) query.getSingleResult();
    }

    @Transactional
    public List<Inventory> findByTransactionCount(Long count) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo cross join inventoryTransactionEntity i where i.count=:count", Inventory.class);
        query.setParameter("count", count);
        return query.getResultList();
    }

    //todo->> one sample for getting the inventoryTransactions relation objects!
    @Transactional
    public List<Inventory> findByProduct(String name) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo cross join inventoryTransactionEntity i where i.product.name=:name", Inventory.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
    @Transactional
    public Inventory findByOrderId(Long id) {
        Query query = entityManager.createQuery("select oo from inventoryEntity oo  where oo.inventoryTransaction.order.id=:id", Inventory.class);
        query.setParameter("id", id);
        return (Inventory) query.getSingleResult();
    }

}
