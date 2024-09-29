package com.mftplus.demo.model.repository;

import com.mftplus.demo.model.entity.InventoryTransaction;
import com.mftplus.demo.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class InventoryTransactionRepository implements AutoCloseable {
    private EntityManager entityManager;

    public  void save (InventoryTransaction inventoryTransaction) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(inventoryTransaction);
        transaction.commit();
    }
    public void edit (InventoryTransaction inventoryTransaction) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(inventoryTransaction);
        transaction.commit();
    }
    public void remove (Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        InventoryTransaction inventoryTransaction = entityManager.find(InventoryTransaction.class,id);
        entityManager.remove(inventoryTransaction);
        transaction.commit();
    }
    public InventoryTransaction findById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(InventoryTransaction.class,id);
    }
    // findBy...
    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
