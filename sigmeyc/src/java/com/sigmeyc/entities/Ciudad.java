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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdCiudades", query = "SELECT c FROM Ciudad c WHERE c.idCiudades = :idCiudades")
    , @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad")
    , @NamedQuery(name = "Ciudad.findByZona", query = "SELECT c FROM Ciudad c WHERE c.zona = :zona")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCiudades")
    private Integer idCiudades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreCiudad")
    private String nombreCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "zona")
    private String zona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadesIdciudades", fetch = FetchType.LAZY)
    private List<Departamento> departamentoList;
    @JoinColumn(name = "localidad_idLocalidad", referencedColumnName = "idLocalidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Localidad localidadidLocalidad;

    public Ciudad() {
    }

    public Ciudad(Integer idCiudades) {
        this.idCiudades = idCiudades;
    }

    public Ciudad(Integer idCiudades, String nombreCiudad, String zona) {
        this.idCiudades = idCiudades;
        this.nombreCiudad = nombreCiudad;
        this.zona = zona;
    }

    public Integer getIdCiudades() {
        return idCiudades;
    }

    public void setIdCiudades(Integer idCiudades) {
        this.idCiudades = idCiudades;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public Localidad getLocalidadidLocalidad() {
        return localidadidLocalidad;
    }

    public void setLocalidadidLocalidad(Localidad localidadidLocalidad) {
        this.localidadidLocalidad = localidadidLocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudades != null ? idCiudades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiudades == null && other.idCiudades != null) || (this.idCiudades != null && !this.idCiudades.equals(other.idCiudades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Ciudad[ idCiudades=" + idCiudades + " ]";
    }
    
}
