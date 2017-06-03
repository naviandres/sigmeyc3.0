package com.sigmeyc.jsf;

import com.sigmeyc.beans.LocalidadFacade;
import com.sigmeyc.entities.Localidad;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("localidadController")
@SessionScoped
public class LocalidadController implements Serializable {

  

    @EJB
    private LocalidadFacade LocalidadFacade;
    private Localidad localidad;

    public LocalidadController() {
    }
    
    @PostConstruct
    public void init(){
        localidad = new Localidad();
        
        
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
 public String guardar() {
        this.LocalidadFacade.create(localidad);
        init();
        return "/crud/localidad/Create.xthml?faces-redirect=true";
    }
    
    public String prepareCreate() {
        return "/crud/localidad/Create.xthml?faces-redirect=true";
    }
    
    public String prepareView(Localidad l) {
        this.localidad = l;
        return "/crud/localidad/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/crud/localidad/List.xthml?faces-redirect=true";
    }

    public List<Localidad> getLocalidades() {
        return this.LocalidadFacade.findAll();
    }

    public String Eliminar(Localidad l) {
        this.LocalidadFacade.remove(l);
        return "/crud/localidad/List.xthml?faces-redirect=true";
    }
    public String Editar(Localidad l) {
        setLocalidad(l);
        return "/crud/localidad/Edit.xthml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        LocalidadFacade.edit(localidad);
        return "/crud/localidad/List.xthml?faces-redirect=true";
    }
   

}
