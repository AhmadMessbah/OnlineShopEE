package com.mftplus.demo.model.service;
import com.mftplus.demo.model.entity.InventoryTransaction;
import com.mftplus.demo.model.repository.CrudRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryTransactionService implements Service<InventoryTransaction, Long>{
    @Override
    public void save(InventoryTransaction inventoryTransaction) throws Exception {
        try(CrudRepository<InventoryTransaction,Long> repository= new CrudRepository<>()) {
            repository.save(inventoryTransaction);
        }
    }

    @Override
    public void edit(InventoryTransaction inventoryTransaction) throws Exception {
        try(CrudRepository<InventoryTransaction,Long> repository= new CrudRepository<>()) {
            repository.edit(inventoryTransaction);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try(CrudRepository<InventoryTransaction, Long>repository= new CrudRepository<>()) {
            repository.remove(id, InventoryTransaction.class);
        }
    }

    @Override
    public InventoryTransaction findById(Long id) throws Exception {
        try(CrudRepository<InventoryTransaction, Long>repository= new CrudRepository<>()){
            return repository.findById(id, InventoryTransaction.class);}
    }

    @Override
    public List<InventoryTransaction> findAll() throws Exception {
        try(CrudRepository<InventoryTransaction, Long>repository= new CrudRepository<>()){
            return repository.findAll(InventoryTransaction.class);}
    }

    public List<InventoryTransaction> findByInventoryId(Long id) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository=new CrudRepository<>()){
            Map<String,Object> params= new HashMap<>();
            params.put(("id"),id);
            List<InventoryTransaction> inventoryTransactionList = repository.findBy("InventoryTransaction.findByInventoryId",params,InventoryTransaction.class);
            if(inventoryTransactionList.isEmpty()){
                return null;
            }else {
                return (List<InventoryTransaction>) inventoryTransactionList.get(0);
            }
        }
    }

    public List<InventoryTransaction> findByProductId(Long id) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository=new CrudRepository<>()){
            Map<String,Object> params= new HashMap<>();
            params.put(("id"),id);
            List<InventoryTransaction> inventoryTransactionList = repository.findBy("InventoryTransaction.findByProductId",params,InventoryTransaction.class);
            if(inventoryTransactionList.isEmpty()){
                return null;
            }else {
                return (List<InventoryTransaction>) inventoryTransactionList.get(0);
            }
        }
    }

    public List<InventoryTransaction> findByOrderId(Long id) throws Exception {
        try (CrudRepository<InventoryTransaction, Long> repository=new CrudRepository<>()){
            Map<String,Object> params= new HashMap<>();
            params.put(("id"),id);
            List<InventoryTransaction> inventoryTransactionList = repository.findBy("InventoryTransaction.findByOrderId",params,InventoryTransaction.class);
            if(inventoryTransactionList.isEmpty()){
                return null;
            }else {
                return (List<InventoryTransaction>) inventoryTransactionList.get(0);
            }
        }
    }

}
