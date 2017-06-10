package com.sigmeyc.jsf;

import com.sigmeyc.beans.EmpresaFacade;
import com.sigmeyc.entities.Empresa;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("empresaController")
@SessionScoped
public class EmpresaController implements Serializable {

  

    @EJB
    private EmpresaFacade EmpresaFacade;
    private Empresa empresa;

    public EmpresaController() {
    }
    
    @PostConstruct
    public void init(){
        empresa = new Empresa();
        
        
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
 public String guardar() {
        this.EmpresaFacade.create(empresa);
        init();
        return "/app/crud/empresa/Create.xthml?faces-redirect=true";
    }
    
    public String prepareCreate() {
        return "/app/crud/empresa/Create.xthml?faces-redirect=true";
    }
    
    public String prepareView(Empresa l) {
        this.empresa = l;
        return "/app/crud/empresa/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/empresa/List.xthml?faces-redirect=true";
    }

    public List<Empresa> getEmpresas() {
        return this.EmpresaFacade.findAll();
    }

    public String Eliminar(Empresa l) {
        this.EmpresaFacade.remove(l);
        return "/app/crud/empresa/List.xthml?faces-redirect=true";
    }
    public String Editar(Empresa l) {
        setEmpresa(l);
        return "/app/crud/empresa/Edit.xthml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        EmpresaFacade.edit(empresa);
        return "/app/crud/empresa/List.xthml?faces-redirect=true";
    }
   

}
