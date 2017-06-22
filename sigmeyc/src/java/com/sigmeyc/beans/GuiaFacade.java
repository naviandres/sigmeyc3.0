/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.beans;

import com.sigmeyc.entities.Guia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
@Stateless
public class GuiaFacade extends AbstractFacade<Guia> {

    @PersistenceContext(unitName = "sigmeycPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuiaFacade() {
        super(Guia.class);
    }
    
    public Guia buscarGuia(int numeroGuia){
       try {
            TypedQuery<Guia> q = getEntityManager().createNamedQuery("Guia.findByNumeroGuia", Guia.class);
            q.setParameter("numeroGuia", numeroGuia);
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
