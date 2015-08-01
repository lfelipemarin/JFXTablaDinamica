/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.rest;

import com.udea.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author felipe
 */
@Stateless
public class CustomerFacade {

    @PersistenceContext(unitName = "JavaFxServerPU")
    private EntityManager em;

    public List<Customer> findAll() {
        return em.createQuery("Select c FROM Customer c").getResultList();
    }

    public List<Customer> findByName(String name) {
        return em.createQuery("SELECT c FROM Customer c WHERE UPPER(c.name) "
                + "LIKE :custName").setParameter("custName", "%" + name.toUpperCase() + "%").getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
