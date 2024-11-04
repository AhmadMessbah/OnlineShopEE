package com.mftplus.demo.model.service;

import com.mftplus.demo.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class FinancialTransactionService implements Service<FinancialTransaction, Long> {
    @Getter
    private static final FinancialTransactionService financialTransactionService = new FinancialTransactionService();

    private FinancialTransactionService() {
    }

    @Override
    public void save(FinancialTransaction transaction) throws Exception {
        try (CrudRepository<FinancialTransaction, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(transaction);
        }
    }

    @Override
    public void edit(FinancialTransaction transaction) throws Exception {
        try (CrudRepository<FinancialTransaction, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(transaction);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<FinancialTransaction, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, FinancialTransaction.class);
        }
    }

    @Override
    public FinancialTransaction findById(Long id) throws Exception {
        try (CrudRepository<FinancialTransaction, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, FinancialTransaction.class);
        }
    }

    @Override
    public List<FinancialTransaction> findAll() throws Exception {
        try (CrudRepository<FinancialTransaction, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(FinancialTransaction.class);
        }
    }

    public List<FinancialTransaction> findByTracingCode(long tracingCode) throws Exception {
        try (CrudRepository<FinancialTransaction, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("tracingCode", tracingCode);
            return crudRepository.findBy("FinancialTransaction.findByTracingCode", params, FinancialTransaction.class);
        }
    }
}
