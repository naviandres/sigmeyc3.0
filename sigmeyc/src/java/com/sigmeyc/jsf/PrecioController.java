package com.sigmeyc.jsf;

import com.sigmeyc.beans.PrecioFacade;
import com.sigmeyc.entities.Precio;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named("precioController")
@SessionScoped
public class PrecioController implements Serializable {

    @EJB
    private PrecioFacade precioFacade;

    private Precio precio;

    public PrecioController() {
    }

    @PostConstruct
    public void init() {
        precio = new Precio();
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }
    
    public void guardar() {
        this.precioFacade.create(precio);
        init();
    }

    public String prepareCreate() {
        return "/app/crud/precio/Create.xhtml?faces-redirect=true";
    }

    public String prepareView(Precio g) {
        this.precio = g;
        return "/app/crud/precio/View.xhtml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/precio/List.xhtml?faces-redirect=true";
    }

    public List<Precio> getPrecios() {
        return this.precioFacade.findAll();
    }

    public String Eliminar(Precio g) {
        this.precioFacade.remove(g);
        return "/app/crud/precio/List.xhtml?faces-redirect=true";
    }

    public String Editar(Precio g) {
        setPrecio(g);
        return "/app/crud/precio/Edit.xhtml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        precioFacade.edit(precio);
        return "/app/crud/precio/Listar.xhtml?faces-redirect=true";
    }

}
