package com.mftplus.demo.model.repository;
import com.mftplus.demo.model.entity.Inventory;
import com.mftplus.demo.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class InventoryRepository implements AutoCloseable {
    private EntityManager entityManager;

    public void save(Inventory inventory) {
        entityManager= JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(inventory);
        transaction.commit();
    }
    public void edit(Inventory inventory){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(inventory);
        transaction.commit();
    }
    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Inventory inventory = entityManager.find(Inventory.class, id);
        entityManager.remove(inventory);
        transaction.commit();
    }
    public Inventory findById (Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        return entityManager.find(Inventory.class,id);
    }
    // findBy...
    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
