package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Report;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ReportService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(Report report) {
        entityManager.persist(report);
    }

    @Transactional
    public void edit(Report report) {
        entityManager.merge(report);
    }

    @Transactional
    public void remove(Integer id) {
        Report report = entityManager.find(Report.class, id);
        entityManager.remove(report);
    }

    @Transactional
    public List<Report> findAll() {
        Query query = entityManager.createQuery("select r from Report r", Report.class);
        return query.getResultList();
    }

    @Transactional
    public Report findById(Integer id) {
        return entityManager.find(Report.class, id);
    }
}
