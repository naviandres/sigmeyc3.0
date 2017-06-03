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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author ivan
 */
@Entity
@Table(name = "novedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n")
    , @NamedQuery(name = "Novedad.findByIdNovedad", query = "SELECT n FROM Novedad n WHERE n.idNovedad = :idNovedad")
    , @NamedQuery(name = "Novedad.findByTipoNovedad", query = "SELECT n FROM Novedad n WHERE n.tipoNovedad = :tipoNovedad")
    , @NamedQuery(name = "Novedad.findByDetalle", query = "SELECT n FROM Novedad n WHERE n.detalle = :detalle")
    , @NamedQuery(name = "Novedad.findByPrioridad", query = "SELECT n FROM Novedad n WHERE n.prioridad = :prioridad")
    , @NamedQuery(name = "Novedad.findByDescripcion", query = "SELECT n FROM Novedad n WHERE n.descripcion = :descripcion")})
public class Novedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNovedad")
    private Integer idNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoNovedad")
    private String tipoNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prioridad")
    private String prioridad;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "mercancias_idMercancia", referencedColumnName = "idMercancia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mercancia mercanciasidMercancia;

    public Novedad() {
    }

    public Novedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Novedad(Integer idNovedad, String tipoNovedad, String detalle, String prioridad) {
        this.idNovedad = idNovedad;
        this.tipoNovedad = tipoNovedad;
        this.detalle = detalle;
        this.prioridad = prioridad;
    }

    public Integer getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public String getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(String tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Mercancia getMercanciasidMercancia() {
        return mercanciasidMercancia;
    }

    public void setMercanciasidMercancia(Mercancia mercanciasidMercancia) {
        this.mercanciasidMercancia = mercanciasidMercancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedad != null ? idNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.idNovedad == null && other.idNovedad != null) || (this.idNovedad != null && !this.idNovedad.equals(other.idNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Novedad[ idNovedad=" + idNovedad + " ]";
    }
    
}
