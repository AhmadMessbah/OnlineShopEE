package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.TicketGroup;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


import java.util.List;

@ApplicationScoped
@Loggable
public class TicketGroupService implements Service<TicketGroup, Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(TicketGroup ticketGroup) {
        entityManager.persist(ticketGroup);

    }

    @Transactional
    @Override
    public void edit(TicketGroup ticketGroup) {
        entityManager.merge(ticketGroup);

    }

    @Transactional
    @Override
    public void remove(Long id) {
        TicketGroup ticketGroup=entityManager.find(TicketGroup.class, id);
        entityManager.remove(ticketGroup);

    }

    @Transactional
    @Override
    public TicketGroup findById(Long id) {
        return entityManager.find(TicketGroup.class, id);
    }

    @Transactional
    @Override
    public List<TicketGroup> findAll() {
        Query query = entityManager.createQuery("select g from tGroupEntity g", TicketGroup.class);
        return query.getResultList();
    }
}
