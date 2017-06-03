package com.sigmeyc.jsf;

import com.sigmeyc.beans.ConductorFacade;
import com.sigmeyc.entities.Conductor;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("conductorController")
@SessionScoped
public class conductorController implements Serializable {

  

    @EJB
    private ConductorFacade ConductorFacade;
    private Conductor conductor;

    public conductorController() {
    }
    
    @PostConstruct
    public void init(){
        conductor = new Conductor();
        
        
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    
 public String guardar() {
        this.ConductorFacade.create(conductor);
        init();
        return "/crud/conductor/Create.xthml?faces-redirect=true";
    }
    
    public String prepareCreate() {
        return "/crud/conductor/Create.xthml?faces-redirect=true";
    }
    
    public String prepareView(Conductor l) {
        this.conductor = l;
        return "/crud/conductor/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/crud/conductor/List.xthml?faces-redirect=true";
    }

    public List<Conductor> getConductores() {
        return this.ConductorFacade.findAll();
    }

    public String Eliminar(Conductor l) {
        this.ConductorFacade.remove(l);
        return "/crud/conductor/List.xthml?faces-redirect=true";
    }
    public String Editar(Conductor l) {
        setConductor(l);
        return "/crud/conductor/Edit.xthml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        ConductorFacade.edit(conductor);
        return "/crud/conductor/List.xthml?faces-redirect=true";
    }
   

}
