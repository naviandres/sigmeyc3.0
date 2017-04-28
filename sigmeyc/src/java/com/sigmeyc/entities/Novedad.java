/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "novedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n")
    , @NamedQuery(name = "Novedad.findByCodigoNovedad", query = "SELECT n FROM Novedad n WHERE n.codigoNovedad = :codigoNovedad")
    , @NamedQuery(name = "Novedad.findByDetalle", query = "SELECT n FROM Novedad n WHERE n.detalle = :detalle")
    , @NamedQuery(name = "Novedad.findByTipoNovedad", query = "SELECT n FROM Novedad n WHERE n.tipoNovedad = :tipoNovedad")
    , @NamedQuery(name = "Novedad.findByDescripcion", query = "SELECT n FROM Novedad n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "Novedad.findByPrioridad", query = "SELECT n FROM Novedad n WHERE n.prioridad = :prioridad")})
public class Novedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoNovedad")
    private Integer codigoNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoNovedad")
    private String tipoNovedad;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prioridad")
    private String prioridad;
    @JoinColumn(name = "mercancias_codigoMercancia", referencedColumnName = "codigoMercancia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mercancia mercanciascodigoMercancia;

    public Novedad() {
    }

    public Novedad(Integer codigoNovedad) {
        this.codigoNovedad = codigoNovedad;
    }

    public Novedad(Integer codigoNovedad, String detalle, String tipoNovedad, String prioridad) {
        this.codigoNovedad = codigoNovedad;
        this.detalle = detalle;
        this.tipoNovedad = tipoNovedad;
        this.prioridad = prioridad;
    }

    public Integer getCodigoNovedad() {
        return codigoNovedad;
    }

    public void setCodigoNovedad(Integer codigoNovedad) {
        this.codigoNovedad = codigoNovedad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(String tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Mercancia getMercanciascodigoMercancia() {
        return mercanciascodigoMercancia;
    }

    public void setMercanciascodigoMercancia(Mercancia mercanciascodigoMercancia) {
        this.mercanciascodigoMercancia = mercanciascodigoMercancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoNovedad != null ? codigoNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.codigoNovedad == null && other.codigoNovedad != null) || (this.codigoNovedad != null && !this.codigoNovedad.equals(other.codigoNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Novedad[ codigoNovedad=" + codigoNovedad + " ]";
    }
    
}
