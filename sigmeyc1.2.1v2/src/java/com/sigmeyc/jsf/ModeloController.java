/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.jsf;

import com.sigmeyc.beans.ModeloFacade;
import com.sigmeyc.entities.Modelo;
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
@Named(value = "modeloController")
@SessionScoped
public class ModeloController implements Serializable {
    @EJB
    private ModeloFacade modeloFacade;
    private Modelo modelo;

    /**
     * Creates a new instance of ModeloController
     */
    public ModeloController() {
    }
    
    @PostConstruct
    public void init(){
        modelo = new Modelo();
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    public void guardar() {
        this.modeloFacade.create(modelo);
        init();
    }

    public String prepareCreate() {
        return "/app/crud/modelo/Create.xhtml?faces-redirect=true";
    }

    public String prepareView(Modelo g) {
        this.modelo = g;
        return "/app/crud/modelo/View.xhtml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/modelo/List.xhtml?faces-redirect=true";
    }

    public List<Modelo> getModelos() {
        return this.modeloFacade.findAll();
    }

    public String Eliminar(Modelo g) {
        this.modeloFacade.remove(g);
        return "/app/crud/modelo/List.xhtml?faces-redirect=true";
    }

    public String Editar(Modelo g) {
        setModelo(modelo);
        return "/app/crud/modelo/Edit.xhtml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        modeloFacade.edit(modelo);
        return "/app/crud/modelo/Listar.xhtml?faces-redirect=true";
    }
    
}
