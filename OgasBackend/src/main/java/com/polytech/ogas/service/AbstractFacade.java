/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polytech.ogas.service;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author epulapp
 */
public abstract class AbstractFacade<T> {
    private final Class<T> entityClass;
    
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        emf = Persistence.createEntityManagerFactory("ogasBackend");
        em = emf.createEntityManager(); 
    }

    public EntityManager getEntityManager(){
        return em;
    }

    public void create(T entity) {
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            getEntityManager().persist(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            Logger.getLogger(e.getMessage());
        }
    }

    public void edit(T entity) {
        EntityTransaction entityTransaction = em.getTransaction();
        try{
            entityTransaction.begin();
            getEntityManager().merge(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            Logger.getLogger(e.getMessage());
        }
    }

    public void remove(T entity) {
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            entity = em.merge(entity);
            em.remove(entity);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            Logger.getLogger(e.getMessage());
        }
        
    }

    public T find(Object id) {
        T t = null;
        try {
             t = getEntityManager().find(entityClass, id);
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
        }
        return t;
    }

    public List<T> findAll() {
        List<T> lst = null;
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            lst = getEntityManager().createQuery(cq).getResultList();
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
        }
        return lst;
    }

    public List<T> findRange(int[] range) {
        List<T> lst = null;
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            q.setMaxResults(range[1] - range[0] + 1);
            q.setFirstResult(range[0]);
            lst = q.getResultList();
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
        }
        return lst;
    }

    public int count() {
        int count = 0;
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
            cq.select(getEntityManager().getCriteriaBuilder().count(rt));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            count = ((Long) q.getSingleResult()).intValue();
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
        }
        return count;
    }
    
}
