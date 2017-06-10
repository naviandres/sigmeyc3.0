package com.sigmeyc.jsf;

import com.sigmeyc.beans.CiudadFacade;
import com.sigmeyc.entities.Ciudad;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("ciudadController")
@SessionScoped
public class CiudadController implements Serializable {

    @EJB
    private CiudadFacade CiudadFacade;
    private Ciudad ciudad;

    public CiudadController() {
    }

    @PostConstruct
    public void init() {
        ciudad = new Ciudad();

    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String guardar() {
        this.CiudadFacade.create(ciudad);
        init();
        return "/app/crud/ciudad/Create.xthml?faces-redirect=true";
    }

    public String prepareCreate() {
        return "/app/crud/ciudad/Create.xthml?faces-redirect=true";
    }

    public String prepareView(Ciudad l) {
        this.ciudad = l;
        return "/app/crud/ciudad/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/ciudad/List.xthml?faces-redirect=true";
    }

    public List<Ciudad> getCiudades() {
        return this.CiudadFacade.findAll();
    }

    public String Eliminar(Ciudad l) {
        this.CiudadFacade.remove(l);
        return "/app/crud/ciudad/List.xthml?faces-redirect=true";
    }

    public String Editar(Ciudad l) {
        setCiudad(l);
        return "/app/crud/ciudad/Edit.xthml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        CiudadFacade.edit(ciudad);
        return "/app/crud/ciudad/List.xthml?faces-redirect=true";
    }

}
