package com.mftplus.demo.model.service;

import com.mftplus.demo.controller.interceptor.annotation.Authorize;
import com.mftplus.demo.model.entity.InventoryTransaction;
import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@Loggable
@Slf4j
public class InventoryTransactionService implements Service<InventoryTransaction, Long>{

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    @Authorize(authority = "ADMIN")
    public void save(InventoryTransaction inventoryTransaction){
        entityManager.persist(inventoryTransaction);
        }


    @Transactional
    @Override
    @Authorize(authority = "ADMIN")
    public void edit(InventoryTransaction inventoryTransaction){
        entityManager.merge(inventoryTransaction);
        }


    @Transactional
    @Override
    @Authorize(authority = "ADMIN")
    public void remove(Long id){
        InventoryTransaction inventoryTransaction = entityManager.find(InventoryTransaction.class, id);
        entityManager.remove(inventoryTransaction);
        }


    @Transactional
    @Override
    public InventoryTransaction findById(Long id){
        return entityManager.find(InventoryTransaction.class, id);
    }

    @Transactional
    @Override
    public List<InventoryTransaction> findAll(){
        Query query = entityManager.createQuery("select oo from inventoryTransactionEntity oo", InventoryTransaction.class);
        return query.getResultList();
    }

    @Transactional
    public InventoryTransaction findByInventoryId(Long id){
        Query query = entityManager.createQuery("select oo from inventoryTransactionEntity oo cross join inventoryEntity e where e.id=:Inventory_Id", InventoryTransaction.class);
        query.setParameter("Inventory_Id", id);
        return (InventoryTransaction) query.getResultList();
    }

    @Transactional
    public InventoryTransaction findByInventoryTitle (String title){
        Query query = entityManager.createQuery("select oo from inventoryTransactionEntity oo cross join inventoryEntity e where e.title=:Inventory_Title",InventoryTransaction.class);
        query.setParameter("Inventory_Title", title);
        return (InventoryTransaction) query.getResultList();
    }

    @Transactional
    public InventoryTransaction findByInventoryProductId(Long id){
        Query query= entityManager.createQuery("select oo from inventoryTransactionEntity oo cross join inventory_product i where i.id=:Inventory_Product_Id", InventoryTransaction.class);
        query.setParameter("Inventory_Product_Id",id);
        return (InventoryTransaction) query.getResultList();
    }

    @Transactional
    public InventoryTransaction findByProductId(Long id){
        Query query = entityManager.createQuery("select oo from inventoryTransactionEntity oo cross join productEntity nn where nn.id = :Product_Id", InventoryTransaction.class);
        query.setParameter("Product_Id", id);
        return (InventoryTransaction) query.getResultList();
    }

    @Transactional
    public InventoryTransaction findByProductName(String name){
        Query query = entityManager.createQuery("select bb from inventoryTransactionEntity bb cross join productEntity nn where nn.name = : Product_Name", InventoryTransaction.class);
        query.setParameter("Product_Name",name);
        return (InventoryTransaction) query.getResultList();
    }

    @Transactional
    public InventoryTransaction findByOrderItemId(Long id){
        Query query = entityManager.createQuery("select oo from inventoryTransactionEntity oo cross join OrderItemEntity nn where nn.id = :Order_Item_Id", InventoryTransaction.class);
        query.setParameter("Order_Item_Id", id);
        return (InventoryTransaction) query.getResultList();
    }

}
