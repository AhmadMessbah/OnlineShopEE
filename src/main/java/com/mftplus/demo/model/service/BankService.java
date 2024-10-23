package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class BankService implements Service<Bank, Long> {
    @Getter
    private static final BankService bankService = new BankService();

    private BankService() {
    }

    @Override
    public void save(Bank bank) throws Exception {
        try (CrudRepository<Bank, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(bank);
        }
    }

    @Override
    public void edit(Bank bank) throws Exception {
        try (CrudRepository<Bank, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(bank);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Bank, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Bank.class);
        }
    }

    @Override
    public Bank findById(Long id) throws Exception {
        try (CrudRepository<Bank, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Bank.class);
        }
    }

    @Override
    public List<Bank> findAll() throws Exception {
        try (CrudRepository<Bank, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Bank.class);
        }
    }

    public List<Bank> findByName(String name) throws Exception {
        try (CrudRepository<Bank, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("name", name + "%");
            return crudRepository.findBy("Bank.findByName", params, Bank.class);
        }
    }
}
