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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "planillas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p")
    , @NamedQuery(name = "Planilla.findByCodigoPlanilla", query = "SELECT p FROM Planilla p WHERE p.codigoPlanilla = :codigoPlanilla")
    , @NamedQuery(name = "Planilla.findByRuta", query = "SELECT p FROM Planilla p WHERE p.ruta = :ruta")
    , @NamedQuery(name = "Planilla.findByCantidadGuias", query = "SELECT p FROM Planilla p WHERE p.cantidadGuias = :cantidadGuias")
    , @NamedQuery(name = "Planilla.findByDescripcion", query = "SELECT p FROM Planilla p WHERE p.descripcion = :descripcion")})
public class Planilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoPlanilla")
    private Integer codigoPlanilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ruta")
    private String ruta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadGuias")
    private int cantidadGuias;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planillascodigoPlanilla1", fetch = FetchType.LAZY)
    private List<Guia> guiaList;

    public Planilla() {
    }

    public Planilla(Integer codigoPlanilla) {
        this.codigoPlanilla = codigoPlanilla;
    }

    public Planilla(Integer codigoPlanilla, String ruta, int cantidadGuias) {
        this.codigoPlanilla = codigoPlanilla;
        this.ruta = ruta;
        this.cantidadGuias = cantidadGuias;
    }

    public Integer getCodigoPlanilla() {
        return codigoPlanilla;
    }

    public void setCodigoPlanilla(Integer codigoPlanilla) {
        this.codigoPlanilla = codigoPlanilla;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getCantidadGuias() {
        return cantidadGuias;
    }

    public void setCantidadGuias(int cantidadGuias) {
        this.cantidadGuias = cantidadGuias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Guia> getGuiaList() {
        return guiaList;
    }

    public void setGuiaList(List<Guia> guiaList) {
        this.guiaList = guiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPlanilla != null ? codigoPlanilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.codigoPlanilla == null && other.codigoPlanilla != null) || (this.codigoPlanilla != null && !this.codigoPlanilla.equals(other.codigoPlanilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Planilla[ codigoPlanilla=" + codigoPlanilla + " ]";
    }
    
}
