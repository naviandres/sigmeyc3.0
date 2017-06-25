/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.beans;

import com.sigmeyc.entities.Novedad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class NovedadFacade extends AbstractFacade<Novedad> {

    @PersistenceContext(unitName = "sigmeycPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NovedadFacade() {
        super(Novedad.class);
    }
    
}
