package com.mftplus.demo.model.service;


import com.mftplus.demo.model.entity.Message;
import com.mftplus.demo.model.entity.Ticket;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped //todo
@Loggable
public class MessageService {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional

    public void save(Message message) {
        entityManager.persist(message);

    }

    @Transactional

    public void edit(Message message) {
        entityManager.merge(message);

    }

    @Transactional

    public Message remove(Long id) {
        Message message = entityManager.find(Message.class, id);
        entityManager.remove(message);
        return message;

    }

    @Transactional

    public Message findById(Long id) {
        return entityManager.find(Message.class, id);
    }

    @Transactional

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
    public Message findByDateTime(String dateTime) {
        Query query=entityManager.createQuery("select m from messageEntity m where m.dateTime=:dateTime", Message.class);
        query.setParameter("dateTime", dateTime);
        return (Message) query.getSingleResult();
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
