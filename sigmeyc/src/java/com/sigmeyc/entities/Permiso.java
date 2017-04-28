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
 * @author daniel
 */
@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByIdentificadorPermisos", query = "SELECT p FROM Permiso p WHERE p.identificadorPermisos = :identificadorPermisos")
    , @NamedQuery(name = "Permiso.findByDescripcion", query = "SELECT p FROM Permiso p WHERE p.descripcion = :descripcion")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificadorPermisos")
    private Integer identificadorPermisos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "roles_has_permisos", joinColumns = {
        @JoinColumn(name = "permisos_identificador_permisos", referencedColumnName = "identificadorPermisos")}, inverseJoinColumns = {
        @JoinColumn(name = "roles_identificador_rol", referencedColumnName = "identificadorRol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> rolList;

    public Permiso() {
    }

    public Permiso(Integer identificadorPermisos) {
        this.identificadorPermisos = identificadorPermisos;
    }

    public Permiso(Integer identificadorPermisos, String descripcion) {
        this.identificadorPermisos = identificadorPermisos;
        this.descripcion = descripcion;
    }

    public Integer getIdentificadorPermisos() {
        return identificadorPermisos;
    }

    public void setIdentificadorPermisos(Integer identificadorPermisos) {
        this.identificadorPermisos = identificadorPermisos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificadorPermisos != null ? identificadorPermisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.identificadorPermisos == null && other.identificadorPermisos != null) || (this.identificadorPermisos != null && !this.identificadorPermisos.equals(other.identificadorPermisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Permiso[ identificadorPermisos=" + identificadorPermisos + " ]";
    }
    
}
