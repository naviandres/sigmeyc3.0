package com.sigmeyc.jsf;

import com.sigmeyc.beans.VehiculoFacade;
import com.sigmeyc.entities.Vehiculo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named("vehiculoController")
@SessionScoped
public class VehiculoController implements Serializable {

    private Integer idVehiculo;
    private String placaVehiculo;
    private String modelo;
    private String tipoVehiculo;
    private String marca;
    private String capacidadCarga;
    private Vehiculo vehiculo;
    @EJB
    private VehiculoFacade vehiculoFacade;

    public VehiculoController() {
    }

    public VehiculoController(Integer idVehiculo, String placaVehiculo, String modelo, String tipoVehiculo, String marca, String capacidadCarga) {
        this.idVehiculo = idVehiculo;
        this.placaVehiculo = placaVehiculo;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(String capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public String guardar() {
        Vehiculo v = new Vehiculo(null, placaVehiculo, modelo, tipoVehiculo, marca, capacidadCarga);
        this.vehiculoFacade.create(v);

        return "Create";
    }

    public String prepareCreate() {
        return "/crud/vehiculo/Create.xhtml";
    }

    public String prepareView(Vehiculo v) {
//        Vehiculo v = this.vehiculoFacade.find(placaVehiculo);
        this.placaVehiculo = v.getPlacaVehiculo();
        this.modelo = v.getModelo();
        this.tipoVehiculo = v.getTipoVehiculo();
        this.marca = v.getMarca();
        this.capacidadCarga = v.getCapacidadCarga();
        return "View";
    }

    public String prepareList() {
        return "List";
    }

    public List<Vehiculo> getVehiculos() {
        return this.vehiculoFacade.findAll();
    }

    public String Eliminar(Vehiculo v) {
        this.vehiculoFacade.remove(v);
        return "List";
    }

    public String Editar(Vehiculo v) {
//        Vehiculo v = this.vehiculoFacade.find(placaVehiculo);
    this.idVehiculo = v.getIdVehiculo();
        this.placaVehiculo = v.getPlacaVehiculo();
        this.modelo = v.getModelo();
        this.tipoVehiculo = v.getTipoVehiculo();
        this.marca = v.getMarca();
        this.capacidadCarga = v.getCapacidadCarga();

        return "Edit";
    }

    public String GuardarEdicion(Integer idVehiculo) {
       Vehiculo v = new Vehiculo(idVehiculo, placaVehiculo, modelo, tipoVehiculo, marca, capacidadCarga);
        this.vehiculoFacade.edit(v);
        return "List";
    }

    public String DestruirVer(String placaVehiculo) {

        return "List";
    }
}
