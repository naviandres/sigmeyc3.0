/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByPlacaVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.placaVehiculo = :placaVehiculo")
    , @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculo.findByTipoVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.tipoVehiculo = :tipoVehiculo")
    , @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculo.findByCapacidadCarga", query = "SELECT v FROM Vehiculo v WHERE v.capacidadCarga = :capacidadCarga")
    , @NamedQuery(name = "Vehiculo.findByEstadoVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.estadoVehiculo = :estadoVehiculo")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "placaVehiculo")
    private Integer placaVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoVehiculo")
    private String tipoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "capacidadCarga")
    private String capacidadCarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estadoVehiculo")
    private String estadoVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculosplacaVehiculo", fetch = FetchType.LAZY)
    private List<Conductor> conductorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculosplacaVehiculo", fetch = FetchType.LAZY)
    private List<Mercancia> mercanciaList;

    public Vehiculo() {
    }

    public Vehiculo(Integer placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public Vehiculo(Integer placaVehiculo, String modelo, String tipoVehiculo, String marca, String capacidadCarga, String estadoVehiculo) {
        this.placaVehiculo = placaVehiculo;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
        this.estadoVehiculo = estadoVehiculo;
    }

    public Integer getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(Integer placaVehiculo) {
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

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    @XmlTransient
    public List<Conductor> getConductorList() {
        return conductorList;
    }

    public void setConductorList(List<Conductor> conductorList) {
        this.conductorList = conductorList;
    }

    @XmlTransient
    public List<Mercancia> getMercanciaList() {
        return mercanciaList;
    }

    public void setMercanciaList(List<Mercancia> mercanciaList) {
        this.mercanciaList = mercanciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placaVehiculo != null ? placaVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.placaVehiculo == null && other.placaVehiculo != null) || (this.placaVehiculo != null && !this.placaVehiculo.equals(other.placaVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Vehiculo[ placaVehiculo=" + placaVehiculo + " ]";
    }
    
}
