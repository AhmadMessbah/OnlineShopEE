package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Ticket;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


import java.util.List;

@ApplicationScoped
@Loggable
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

    @Transactional
    public List<Ticket> findByTitle(String title) {
        Query query=entityManager.createQuery("select t from ticketEntity t where t.title=:title", Ticket.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
    @Transactional
    public List<Ticket> findByText(String text) {
        Query query=entityManager.createQuery("select t from ticketEntity t where t.text=:text", Ticket.class);
        query.setParameter("text", text);
        return query.getResultList();
    }
    @Transactional
    public Ticket findByResponseType(String responseType) {
        Query query=entityManager.createQuery("select t from ticketEntity t where t.responseType=:responseType", Ticket.class);
        query.setParameter("responseType", responseType);
        return (Ticket) query.getSingleResult();
    }
    @Transactional
    public Ticket findByUsername(String username) {
        Query query=entityManager.createQuery("select t from ticketEntity t where t.user.username=:username", Ticket.class);
        query.setParameter("username", username);
        return (Ticket) query.getSingleResult();
    }
    @Transactional
    public Ticket findByUserEmail(String email) {
        Query query=entityManager.createQuery("select t from ticketEntity t where t.user.email=:email", Ticket.class);
        query.setParameter("email", email);
        return (Ticket) query.getSingleResult();
    }
    @Transactional
    public List <Ticket> findByMessageTitle(String title) {
        Query query=entityManager.createQuery("select t from ticketEntity t cross join messageEntity  m where m.title =:title", Ticket.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
    @Transactional
    public List <Ticket> findByMessageText(String text) {
        Query query=entityManager.createQuery("select t from ticketEntity t cross join messageEntity  m where m.text =:text", Ticket.class);
        query.setParameter("text", text);
        return query.getResultList();
    }
    @Transactional
    public Ticket findByTicketGroupName(String name) {
        Query query=entityManager.createQuery("select t from ticketEntity t where t.ticketGroup.name=:name", Ticket.class);
        query.setParameter("name", name);
        return (Ticket) query.getSingleResult();
    }
}
