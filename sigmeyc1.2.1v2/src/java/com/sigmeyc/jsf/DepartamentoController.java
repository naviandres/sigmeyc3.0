package com.sigmeyc.jsf;

import com.sigmeyc.beans.DepartamentoFacade;
import com.sigmeyc.entities.Departamento;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("departamentoController")
@SessionScoped
public class DepartamentoController implements Serializable {

  

    @EJB
    private DepartamentoFacade DepartamentoFacade;
    private Departamento departamento;

    public DepartamentoController() {
    }
    
    @PostConstruct
    public void init(){
        departamento = new Departamento();
        
        
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
 public String guardar() {
        this.DepartamentoFacade.create(departamento);
        init();
        return "/app/crud/departamento/Create.xthml?faces-redirect=true";
    }
    
    public String prepareCreate() {
        return "/app/crud/departamento/Create.xthml?faces-redirect=true";
    }
    
    public String prepareView(Departamento l) {
        this.departamento = l;
        return "/app/crud/departamento/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/departamento/List.xthml?faces-redirect=true";
    }

    public List<Departamento> getDepartamentos() {
        return this.DepartamentoFacade.findAll();
    }

    public String Eliminar(Departamento l) {
        this.DepartamentoFacade.remove(l);
        return "/app/crud/departamento/List.xthml?faces-redirect=true";
    }
    public String Editar(Departamento l) {
        setDepartamento(l);
        return "/app/crud/departamento/Edit.xthml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        DepartamentoFacade.edit(departamento);
        return "/app/crud/departamento/List.xthml?faces-redirect=true";
    }
   

}
