package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.FinancialDoc;
import com.mftplus.demo.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class FinancialDocService implements Service<FinancialDoc, Long> {
    @Getter
    private static final FinancialDocService financialDocService = new FinancialDocService();

    private FinancialDocService() {
    }

    @Override
    public void save(FinancialDoc doc) throws Exception {
        try (CrudRepository<FinancialDoc, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(doc);
        }
    }

    @Override
    public void edit(FinancialDoc doc) throws Exception {
        try (CrudRepository<FinancialDoc, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(doc);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<FinancialDoc, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, FinancialDoc.class);
        }
    }

    @Override
    public FinancialDoc findById(Long id) throws Exception {
        try (CrudRepository<FinancialDoc, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, FinancialDoc.class);
        }
    }

    @Override
    public List<FinancialDoc> findAll() throws Exception {
        try (CrudRepository<FinancialDoc, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(FinancialDoc.class);
        }
    }

    public List<FinancialDoc> findByDocNumber(long docNumber) throws Exception {
        try (CrudRepository<FinancialDoc, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("docNumber", docNumber);
            return crudRepository.findBy("FinancialDoc.findByDocNumber", params, FinancialDoc.class);
        }
    }
}
