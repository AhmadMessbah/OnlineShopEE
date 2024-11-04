package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.FinancialDoc;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class FinancialDocService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(FinancialDoc financialDoc) {
        entityManager.persist(financialDoc);
    }

    @Transactional
    public void edit(FinancialDoc financialDoc) {
        entityManager.merge(financialDoc);
    }

    @Transactional
    public void remove(Integer id) {
        FinancialDoc financialDoc = entityManager.find(FinancialDoc.class, id);
        entityManager.remove(financialDoc);
    }

    @Transactional
    public List<FinancialDoc> findAll() {
        Query query = entityManager.createQuery("select f from FinancialDoc f", FinancialDoc.class);
        return query.getResultList();
    }

    @Transactional
    public FinancialDoc findById(Integer id) {
        return entityManager.find(FinancialDoc.class, id);
    }
}
