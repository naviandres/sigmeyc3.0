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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "planillas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p")
    , @NamedQuery(name = "Planilla.findByIdPlanilla", query = "SELECT p FROM Planilla p WHERE p.idPlanilla = :idPlanilla")
    , @NamedQuery(name = "Planilla.findByCantidadGuias", query = "SELECT p FROM Planilla p WHERE p.cantidadGuias = :cantidadGuias")})
public class Planilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlanilla")
    private Integer idPlanilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadGuias")
    private int cantidadGuias;
    @JoinColumn(name = "rutas_idRutas", referencedColumnName = "idRutas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ruta rutasidRutas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planillasidPlanilla", fetch = FetchType.LAZY)
    private List<Guia> guiaList;

    public Planilla() {
    }

    public Planilla(Integer idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public Planilla(Integer idPlanilla, int cantidadGuias) {
        this.idPlanilla = idPlanilla;
        this.cantidadGuias = cantidadGuias;
    }

    public Planilla(Integer idPlanilla, int cantidadGuias,Ruta rutasidRutas) {
        this.idPlanilla = idPlanilla;
        this.cantidadGuias = cantidadGuias;
        this.rutasidRutas = rutasidRutas;
    }

    public Integer getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(Integer idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public int getCantidadGuias() {
        return cantidadGuias;
    }

    public void setCantidadGuias(int cantidadGuias) {
        this.cantidadGuias = cantidadGuias;
    }

    public Ruta getRutasidRutas() {
        return rutasidRutas;
    }

    public void setRutasidRutas(Ruta rutasidRutas) {
        this.rutasidRutas = rutasidRutas;
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
        hash += (idPlanilla != null ? idPlanilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.idPlanilla == null && other.idPlanilla != null) || (this.idPlanilla != null && !this.idPlanilla.equals(other.idPlanilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Planilla[ idPlanilla=" + idPlanilla + " ]";
    }

}
