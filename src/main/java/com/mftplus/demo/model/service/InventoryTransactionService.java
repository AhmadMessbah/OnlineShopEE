package com.mftplus.demo.model.service;
import com.mftplus.demo.model.entity.InventoryTransaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@Slf4j
public class InventoryTransactionService{

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(InventoryTransaction inventoryTransaction){
        entityManager.persist(inventoryTransaction);
        }


    @Transactional
    public void edit(InventoryTransaction inventoryTransaction){
        entityManager.merge(inventoryTransaction);
        }


    @Transactional
    public void remove(Long id){
        InventoryTransaction inventoryTransaction = entityManager.find(InventoryTransaction.class, id);
        entityManager.remove(inventoryTransaction);
        }


    @Transactional
    public InventoryTransaction findById(Long id){
        return entityManager.find(InventoryTransaction.class, id);
    }

    @Transactional
    public List<InventoryTransaction> findAll(){
        Query query = entityManager.createQuery("select oo from inventoryTransactionEntity oo", InventoryTransaction.class);
        return query.getResultList();
    }

    @Transactional
    public List<InventoryTransaction> findByInventoryId(Long id){
        Query query = entityManager.createQuery("select oo from inventoryTransactionEntity oo cross join inventoryEntity e where e.id=:id", InventoryTransaction.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<InventoryTransaction> findByProductId(Long id){
        Query query = entityManager.createQuery("select oo from inventoryTransactionEntity oo where oo.product.id = :product", InventoryTransaction.class);
        query.setParameter("product", id);
        return query.getResultList();
    }

    public List<InventoryTransaction> findByOrderId(Long id){
        Query query = entityManager.createQuery("select oo from inventoryTransactionEntity oo where oo.order.id = :order", InventoryTransaction.class);
        query.setParameter("order", id);
        return query.getResultList();
    }

}
