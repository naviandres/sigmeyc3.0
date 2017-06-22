/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.jsf;

import com.sigmeyc.beans.RutaFacade;
import com.sigmeyc.entities.Ruta;
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
@Named(value = "rutaController")
@SessionScoped
public class RutaController implements Serializable {
    @EJB
    private RutaFacade rutaFacade;
    private Ruta ruta;

    /**
     * Creates a new instance of RutaController
     */
    public RutaController() {
    }
    
    @PostConstruct
    public void init(){
        ruta = new Ruta();
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
    
    public void guardar() {
        this.rutaFacade.create(ruta);
        init();
    }

    public String prepareCreate() {
        return "/app/crud/ruta/Create.xhtml?faces-redirect=true";
    }

    public String prepareView(Ruta r) {
        this.ruta = r;
        return "/app/crud/ruta/View.xhtml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/ruta/List.xhtml?faces-redirect=true";
    }

    public List<Ruta> getRutas() {
        return this.rutaFacade.findAll();
    }

    public String Eliminar(Ruta r) {
        this.rutaFacade.remove(r);
        return "/app/crud/ruta/List.xhtml?faces-redirect=true";
    }

    public String Editar(Ruta r) {
        setRuta(ruta);
        return "/app/crud/ruta/Edit.xhtml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        rutaFacade.edit(ruta);
        return "/app/crud/ruta/Listar.xhtml?faces-redirect=true";
    }    
}