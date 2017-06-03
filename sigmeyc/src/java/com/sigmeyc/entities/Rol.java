/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdentificadorRol", query = "SELECT r FROM Rol r WHERE r.identificadorRol = :identificadorRol")
    , @NamedQuery(name = "Rol.findByNombreRol", query = "SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol")
    , @NamedQuery(name = "Rol.findByDetalleRol", query = "SELECT r FROM Rol r WHERE r.detalleRol = :detalleRol")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identificadorRol")
    private Integer identificadorRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreRol")
    private String nombreRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "detalleRol")
    private String detalleRol;
    @ManyToMany(mappedBy = "rolList", fetch = FetchType.LAZY)
    private List<Permiso> permisos;
    
    @ManyToMany(mappedBy="roles", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    public Rol() {
    }

    public Rol(Integer identificadorRol) {
        this.identificadorRol = identificadorRol;
    }

    public Rol(Integer identificadorRol, String nombreRol, String detalleRol) {
        this.identificadorRol = identificadorRol;
        this.nombreRol = nombreRol;
        this.detalleRol = detalleRol;
    }

    public Integer getIdentificadorRol() {
        return identificadorRol;
    }

    public void setIdentificadorRol(Integer identificadorRol) {
        this.identificadorRol = identificadorRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDetalleRol() {
        return detalleRol;
    }

    public void setDetalleRol(String detalleRol) {
        this.detalleRol = detalleRol;
    }

    @XmlTransient
    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    @XmlTransient
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificadorRol != null ? identificadorRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.identificadorRol == null && other.identificadorRol != null) || (this.identificadorRol != null && !this.identificadorRol.equals(other.identificadorRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Rol[ identificadorRol=" + identificadorRol + " ]";
    }
    
}
