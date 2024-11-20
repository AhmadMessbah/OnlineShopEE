package com.mftplus.demo.model.service;


import com.mftplus.demo.model.entity.Message;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Loggable
public class MessageService implements Service<Message, Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Message message) {
        entityManager.persist(message);

    }

    @Transactional
    @Override
    public void edit(Message message) {
        entityManager.merge(message);

    }

    @Transactional
    @Override
    public void remove(Long id) {
        Message message = entityManager.find(Message.class, id);
        entityManager.remove(message);

    }

    @Transactional
    @Override
    public Message findById(Long id) {
        return entityManager.find(Message.class, id);
    }

    @Transactional
    @Override
    public List<Message> findAll() {
        Query query = entityManager.createQuery("select m from messageEntity m", Message.class);
        return query.getResultList();

    }
    @Transactional
    public List<Message> findByTitle(String title) {
        Query query=entityManager.createQuery("select m from messageEntity m where m.title=:title", Message.class);
       query.setParameter("title", title);
       return query.getResultList();
    }
    @Transactional
    public List<Message> findByText(String text) {
        Query query=entityManager.createQuery("select m from messageEntity m where m.text=:text", Message.class);
        query.setParameter("text", text);
        return query.getResultList();
    }
    @Transactional
    public Message findByUsername(String username) {
        Query query=entityManager.createQuery("select m from messageEntity m where m.user.username=:username", Message.class);
        query.setParameter("username", username);
        return (Message) query.getSingleResult();
    }

    @Transactional
    public Message findByUserEmail(String email) {
        Query query=entityManager.createQuery("select m from messageEntity m where m.user.email=:email", Message.class);
        query.setParameter("email", email);
        return (Message) query.getSingleResult();
    }
}