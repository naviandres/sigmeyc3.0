package com.sigmeyc.jsf;

import com.sigmeyc.beans.VehiculoFacade;
import com.sigmeyc.entities.Marca;
import com.sigmeyc.entities.Vehiculo;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import com.sigmeyc.beans.MarcaFacade;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("vehiculoController")
@SessionScoped
public class VehiculoController implements Serializable {

    @EJB
    private VehiculoFacade VehiculoFacade;
    private Vehiculo vehiculo;
    @EJB
    private MarcaFacade marcaFacade;
    private Marca marcas;

    public VehiculoController() {
    }

    @PostConstruct
    public void init() {
        vehiculo = new Vehiculo();

    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Marca> getMarcas() {
        return this.marcaFacade.findAll();
    }

    public String guardar() {
        this.VehiculoFacade.create(vehiculo);
        init();
        return "/app/crud/vehiculo/Create.xthml?faces-redirect=true";
    }

    public String prepareCreate() {
        return "/app/crud/vehiculo/Create.xthml?faces-redirect=true";
    }

    public String prepareView(Vehiculo l) {
        this.vehiculo = l;
        return "/app/crud/vehiculo/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/vehiculo/List.xthml?faces-redirect=true";
    }

    public List<Vehiculo> getVehiculos() {
        return this.VehiculoFacade.findAll();
    }

    public String Eliminar(Vehiculo l) {
        this.VehiculoFacade.remove(l);
        return "/app/crud/vehiculo/List.xthml?faces-redirect=true";
    }

    public String Editar(Vehiculo l) {
        setVehiculo(l);
        return "/app/crud/vehiculo/Edit.xthml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        VehiculoFacade.edit(vehiculo);
        return "/app/crud/vehiculo/List.xthml?faces-redirect=true";
    }

}
