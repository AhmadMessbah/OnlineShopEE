package com.mftplus.demo.model.service;

import com.mftplus.demo.controller.interceptor.annotation.Authorize;
import com.mftplus.demo.model.entity.InventoryProduct;
import com.mftplus.demo.model.entity.Transaction;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@ApplicationScoped
@Loggable
@Slf4j
public class InventoryProductService implements Service<InventoryProduct, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Override
    @Authorize(authority = "ADMIN")
    @Transactional
    public void save (InventoryProduct inventoryProduct){
       entityManager.persist(inventoryProduct);
    }

    @Transactional
    @Override
    @Authorize(authority = "ADMIN")
    public void edit (InventoryProduct inventoryProduct){
        entityManager.merge(inventoryProduct);
    }

    @Transactional
    @Override
    @Authorize(authority = "ADMIN")
    public void remove (Long id){
        InventoryProduct inventoryProduct = entityManager.find(InventoryProduct.class,id);
        entityManager.remove(inventoryProduct);
    }

    @Transactional
    @Override
    public List<InventoryProduct> findAll(){
        Query query = entityManager.createQuery("select bb from inventory_product bb", InventoryProduct.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public InventoryProduct findById(Long id){
              return entityManager.find(InventoryProduct.class,id);
    }

    @Transactional
    public InventoryProduct findByQuantity (Double quantity){
        Query query = entityManager.createQuery("select bb from inventory_product bb where bb.quantity = : quantity", InventoryProduct.class);
        query.setParameter("quantity", quantity);
        return (InventoryProduct) query.getResultList();
    }

    @Transactional
    public InventoryProduct findByProductId(Long id) {
        Query query = entityManager.createQuery("select bb from inventory_product bb where bb.product.id =:Product_Id", InventoryProduct.class);
        query.setParameter("Product_Id", id);
        return (InventoryProduct) query.getResultList();
    }

    @Transactional
    public InventoryProduct findByProductName(String name) {
        Query query = entityManager.createQuery("select bb from inventory_product bb where bb.product.name = :Product_Name",InventoryProduct.class);
        query.setParameter("Product_Name",name);
        return (InventoryProduct) query.getResultList();
    }

    @Transactional
    public InventoryProduct findByInventoryTransactionId (Long id) {
        Query query = entityManager.createQuery("select bb from inventory_product bb cross join inventoryTransactionEntity nn where nn.inventoryTransaction.id= :Transaction_Id", InventoryProduct.class);
        query.setParameter("Transaction_Id", id);
        return (InventoryProduct) query.getResultList();
    }

    @Transactional
    public InventoryProduct findByInventoryId (Long id) {
        Query query = entityManager.createQuery("select bb from inventory_product bb where bb.inventory.id = :Inventory_Id ", InventoryProduct.class);
        query.setParameter("Inventory_Id",id);
        return (InventoryProduct) query.getResultList();
    }

}
