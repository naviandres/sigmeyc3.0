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
@Table(name = "localidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l")
    , @NamedQuery(name = "Localidad.findByIdLocalidad", query = "SELECT l FROM Localidad l WHERE l.idLocalidad = :idLocalidad")
    , @NamedQuery(name = "Localidad.findByNombreLocalidad", query = "SELECT l FROM Localidad l WHERE l.nombreLocalidad = :nombreLocalidad")})
public class Localidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idLocalidad")
    private Integer idLocalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreLocalidad")
    private String nombreLocalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidadidLocalidad", fetch = FetchType.LAZY)
    private List<Ciudad> ciudadList;

    public Localidad() {
    }

    public Localidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Localidad(Integer idLocalidad, String nombreLocalidad) {
        this.idLocalidad = idLocalidad;
        this.nombreLocalidad = nombreLocalidad;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalidad != null ? idLocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.idLocalidad == null && other.idLocalidad != null) || (this.idLocalidad != null && !this.idLocalidad.equals(other.idLocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Localidad[ idLocalidad=" + idLocalidad + " ]";
    }
    
}
