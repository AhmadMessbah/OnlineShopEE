package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.entity.Ticket;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@ApplicationScoped
@Loggable
@Slf4j
public class TicketService implements Service<Ticket,Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Ticket ticket) {
        entityManager.persist(ticket);

    }

    @Transactional
    @Override
    public void edit(Ticket ticket) {
        entityManager.merge(ticket);

    }

    @Transactional
    @Override
    public void remove(Long id) {
        Ticket ticket = entityManager.find(Ticket.class, id);
        entityManager.remove(ticket);

    }

    @Transactional
    @Override
    public Ticket findById(Long id) {
        return entityManager.find(Ticket.class, id);
    }

    @Transactional
    @Override
    public List<Ticket> findAll() {
        Query query = entityManager.createQuery("select t from ticketEntity t", Ticket.class);
        return query.getResultList();

    }
}
