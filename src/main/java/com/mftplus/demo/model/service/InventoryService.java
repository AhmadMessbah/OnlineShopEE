//package com.mftplus.demo.model.service;
//import com.mftplus.demo.model.entity.Inventory;
//import com.mftplus.demo.model.repository.CrudRepository;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class InventoryService implements Service<Inventory, Long> {
//
//
//    @Override
//    public void save(Inventory inventory) throws Exception {
//        try(CrudRepository<Inventory, Long> repository = new CrudRepository<>()){
//            repository.save(inventory);
//        }
//    }
//
//    @Override
//    public void edit(Inventory inventory) throws Exception {
//        try(CrudRepository<Inventory, Long> repository = new CrudRepository<>()){
//            repository.edit(inventory);}
//    }
//
//    @Override
//    public void remove(Long id) throws Exception {
//        try(CrudRepository<Inventory, Long> repository = new CrudRepository<>()){
//            repository.remove(id, Inventory.class);}
//    }
//
//    @Override
//    public Inventory findById(Long id) throws Exception {
//        try(CrudRepository<Inventory, Long> repository = new CrudRepository<>()){
//          return repository.findById(id, Inventory.class);}
//    }
//
//    @Override
//    public List<Inventory> findAll() throws Exception {
//        try(CrudRepository<Inventory, Long> repository = new CrudRepository<>()){
//            return repository.findAll(Inventory.class);}
//    }
//
//    public List<Inventory> findByTitle (String title) throws Exception {
//        try(CrudRepository<Inventory, Long> repository = new CrudRepository<>()){
//            HashMap<String, Object> params = new HashMap<>();
//            params.put("title",title+"%");
//            return repository.findBy("Inventory.findByTitle", params, Inventory.class);
//        }
//    }
//
//    public List<Inventory> findByAddress (String address) throws Exception {
//        try(CrudRepository<Inventory, Long> repository = new CrudRepository<>()){
//            HashMap<String, Object> params = new HashMap<>();
//            params.put("address",address+"%");
//            return repository.findBy("Inventory.findByAddress", params, Inventory.class);
//        }
//    }
//
//    public List<Inventory> findByPhone (String phone) throws Exception {
//        try(CrudRepository<Inventory, Long> repository = new CrudRepository<>()){
//            HashMap<String, Object> params = new HashMap<>();
//            params.put("phone",phone+"%");
//            return repository.findBy("Inventory.findByPhone", params, Inventory.class);
//        }
//    }
//}
