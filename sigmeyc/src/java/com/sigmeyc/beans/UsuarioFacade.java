/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.beans;

import com.sigmeyc.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "sigmeycPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario login(String email, String clave) {
        try {
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Usuario> q = getEntityManager().createNamedQuery("Usuario.findLogin", Usuario.class);
            q.setParameter("ema", email);
            q.setParameter("clv", clave);
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
