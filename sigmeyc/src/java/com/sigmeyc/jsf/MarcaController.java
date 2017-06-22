/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.jsf;

import com.sigmeyc.beans.MarcaFacade;
import com.sigmeyc.entities.Marca;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Nick
 */
@Named(value = "marcaController")
@SessionScoped
public class MarcaController implements Serializable {
    @EJB
    private MarcaFacade marcaFacade;

    private Marca marca;
    public MarcaController() {
    }
    
    @PostConstruct
    public void init() {
        marca = new Marca();
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    public String guardar() {
        this.marcaFacade.create(marca);
        init();
        return "/app/crud/marca/Create.xthml?faces-redirect=true";
    }

    public String prepareCreate() {
        return "/app/crud/marca/Create.xhtml?faces-redirect=true";
    }

    public String prepareView(Marca g) {
        this.marca = g;
        return "/app/crud/marca/View.xhtml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/marca/List.xhtml?faces-redirect=true";
    }

    public List<Marca> getMarcas() {
        return this.marcaFacade.findAll();
    }

    public String Eliminar(Marca marca) {
        this.marcaFacade.remove(marca);
        return "/app/crud/marca/List.xhtml?faces-redirect=true";
    }

    public String Editar(Marca marca) {
        setMarca(marca);
        return "/app/crud/marca/Edit.xhtml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        marcaFacade.edit(marca);
        return "/app/crud/marca/Listar.xhtml?faces-redirect=true";
    }
   
}
