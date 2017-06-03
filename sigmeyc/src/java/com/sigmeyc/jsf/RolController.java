package com.sigmeyc.jsf;

import com.sigmeyc.entities.Rol;

import com.sigmeyc.beans.RolFacade;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;


@Named("rolController")
@SessionScoped
public class RolController implements Serializable {

//  
    @EJB
    private RolFacade rolFacade;
    
    private List<Rol> roles;
    /**
     * Creates a new instance of RolController
     */
    public RolController() {
    }
    
    @PostConstruct
    public void init(){
        roles = rolFacade.findAll();
    }

    public List<Rol> getRoles() {
        return roles;
    }

}
