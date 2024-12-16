package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.TicketGroup;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped  //todo
@Loggable
public class TicketGroupService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Transactional

    public void save(TicketGroup ticketGroup) {
        entityManager.persist(ticketGroup);

    }

    @Transactional

    public void edit(TicketGroup ticketGroup) {
        entityManager.merge(ticketGroup);

    }

    @Transactional

    public TicketGroup remove(Long id) {
        TicketGroup ticketGroup = entityManager.find(TicketGroup.class, id);
        entityManager.remove(ticketGroup);
        return ticketGroup;

    }

    @Transactional

    public TicketGroup findById(Long id) {
        return entityManager.find(TicketGroup.class, id);
    }

    @Transactional

    public List<TicketGroup> findAll() {
        Query query = entityManager.createQuery("select g from tGroupEntity g", TicketGroup.class);
        return query.getResultList();
    }

    @Transactional
    public List<TicketGroup> findByName(String name) {
        Query query = entityManager.createQuery("select g from tGroupEntity g where g.name =:name", TicketGroup.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
    @Transactional
    public List<TicketGroup> findByChild(String name) {
        Query query = entityManager.createQuery("select g from tGroupEntity g where g.childList =:name", TicketGroup.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
    @Transactional
    public List<TicketGroup> findByParent(String name) {
        Query query = entityManager.createQuery("select g from tGroupEntity g where g.parent =:name", TicketGroup.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
