package com.sigmeyc.jsf;

import com.sigmeyc.beans.NovedadFacade;
import com.sigmeyc.entities.Novedad;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("novedadController")
@SessionScoped
public class NovedadController implements Serializable {

  

    @EJB
    private NovedadFacade NovedadFacade;
    private Novedad novedad;

    public NovedadController() {
    }
    
    @PostConstruct
    public void init(){
        novedad = new Novedad();
        
        
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }
    
 public String guardar() {
        this.NovedadFacade.create(novedad);
        init();
        return "/app/crud/novedad/Create.xthml?faces-redirect=true";
    }
    
    public String prepareCreate() {
        return "/app/crud/novedad/Create.xthml?faces-redirect=true";
    }
    
    public String prepareView(Novedad l) {
        this.novedad = l;
        return "/app/crud/novedad/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/novedad/List.xthml?faces-redirect=true";
    }

    public List<Novedad> getNovedades() {
        return this.NovedadFacade.findAll();
    }

    public String Eliminar(Novedad l) {
        this.NovedadFacade.remove(l);
        return "/app/crud/novedad/List.xthml?faces-redirect=true";
    }
    public String Editar(Novedad l) {
        setNovedad(l);
        return "/app/crud/novedad/Edit.xthml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        NovedadFacade.edit(novedad);
        return "/app/crud/novedad/List.xthml?faces-redirect=true";
    }
   

}
