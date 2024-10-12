package com.mftplus.demo.model.repository;

import com.mftplus.demo.model.entity.Base;
import com.mftplus.demo.model.utils.JpaProvider;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;

public class CrudRepository <T extends Base, I> implements AutoCloseable{
    private EntityManager entityManager;

    public void save(T t) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(t);
        entityTransaction.commit();
    }

    public void edit(T t) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(t);
        entityTransaction.commit();
    }

    //    public void remove(I id, Class<T> tClass) {  //physical remove(be remove from db)
//        entityManager = JpaProvider.getJpa().getEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//        T entity = entityManager.find(tClass, id);
//        entityManager.remove(entity);
//        entityTransaction.commit();
//    }
    public void remove(I id, Class<T> tClass) {  //logic remove(does not remove from db)
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        T entity = entityManager.find(tClass, id);
        entity.setDeleted(true);
        entityManager.merge(entity);
        entityManager.remove(entity);
        entityTransaction.commit();
    }




    public T findById(I id, Class<T> tClass) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        return entityManager.find(tClass, id);
    }

    public List<T> findAll(Class<T> tClass) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        Query query = entityManager.createQuery(String.format("select oo from %s oo where oo.deleted=false", tClass.getAnnotation(Entity.class).name()), tClass);
        return query.getResultList();
    }

    public List<T> findBy(String queryName, Map<String, Object> params, Class<T> tClass) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        Query query = entityManager.createNamedQuery(queryName, tClass);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return query.getResultList();
    }


    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
