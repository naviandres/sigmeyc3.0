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
 * @author ivan
 */
@Entity
@Table(name = "rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r")
    , @NamedQuery(name = "Ruta.findByIdRutas", query = "SELECT r FROM Ruta r WHERE r.idRutas = :idRutas")
    , @NamedQuery(name = "Ruta.findByNombre", query = "SELECT r FROM Ruta r WHERE r.nombre = :nombre")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRutas")
    private Integer idRutas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutasidRutas", fetch = FetchType.LAZY)
    private List<Planilla> planillaList;

    public Ruta() {
    }

    public Ruta(Integer idRutas) {
        this.idRutas = idRutas;
    }

    public Ruta(Integer idRutas, String nombre) {
        this.idRutas = idRutas;
        this.nombre = nombre;
    }

    public Integer getIdRutas() {
        return idRutas;
    }

    public void setIdRutas(Integer idRutas) {
        this.idRutas = idRutas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Planilla> getPlanillaList() {
        return planillaList;
    }

    public void setPlanillaList(List<Planilla> planillaList) {
        this.planillaList = planillaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRutas != null ? idRutas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.idRutas == null && other.idRutas != null) || (this.idRutas != null && !this.idRutas.equals(other.idRutas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Ruta[ idRutas=" + idRutas + " ]";
    }
    
}
