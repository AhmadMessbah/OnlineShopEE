package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.ProductGroup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@ApplicationScoped
@Slf4j

public class ProductGroupService implements Service<ProductGroup, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(ProductGroup ProductGroup) {

        entityManager.persist(ProductGroup);
    }

    @Transactional
    @Override
    public void edit(ProductGroup ProductGroup) {
        entityManager.merge(ProductGroup);

    }

    @Transactional
    @Override
    public void remove(Long id) {
        ProductGroup ProductGroup = entityManager.find(ProductGroup.class, id);
        entityManager.remove(ProductGroup);
    }

    @Transactional
    @Override
    public ProductGroup findById(Long id) {
        return entityManager.find(ProductGroup.class, id);

    }

    @Transactional
    @Override
    public List<ProductGroup> findAll() {
        Query query = entityManager.createQuery("select p from productGroupEntity p", ProductGroup.class);
        return query.getResultList();
    }

    @Transactional
    public List<ProductGroup> findByName(String name) {
        Query query = entityManager.createQuery("select p from productGroupEntity p where p.name = : name", ProductGroup.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Transactional
    public List<ProductGroup> findByChild(String child) {
        Query query = entityManager.createQuery("select p from productGroupEntity p where p.child = : child", ProductGroup.class);
        query.setParameter("child", child);
        return query.getResultList();
    }

    @Transactional
    public List<ProductGroup> findByParent(String parent) {
        Query query = entityManager.createQuery("select p from productGroupEntity p where p.parent = : parent", ProductGroup.class);
        query.setParameter("parent", parent);
        return query.getResultList();
    }

}
