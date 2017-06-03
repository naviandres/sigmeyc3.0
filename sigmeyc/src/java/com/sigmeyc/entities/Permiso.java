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
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByIdPermisos", query = "SELECT p FROM Permiso p WHERE p.idPermisos = :idPermisos")
    , @NamedQuery(name = "Permiso.findByNombre", query = "SELECT p FROM Permiso p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Permiso.findByUrl", query = "SELECT p FROM Permiso p WHERE p.url = :url")
    , @NamedQuery(name = "Permiso.findByIcon", query = "SELECT p FROM Permiso p WHERE p.icon = :icon")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermisos")
    private Integer idPermisos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "url")
    private String url;
    @Size(max = 45)
    @Column(name = "icon")
    private String icon;
    @JoinTable(name = "roles_has_permisos", joinColumns = {
        @JoinColumn(name = "permisos_idPermisos", referencedColumnName = "idPermisos")}, inverseJoinColumns = {
        @JoinColumn(name = "roles_identificadorRol", referencedColumnName = "identificadorRol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> rolList;

    public Permiso() {
    }

    public Permiso(Integer idPermisos) {
        this.idPermisos = idPermisos;
    }

    public Permiso(Integer idPermisos, String nombre, String url) {
        this.idPermisos = idPermisos;
        this.nombre = nombre;
        this.url = url;
    }

    public Integer getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(Integer idPermisos) {
        this.idPermisos = idPermisos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
        hash += (idPermisos != null ? idPermisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idPermisos == null && other.idPermisos != null) || (this.idPermisos != null && !this.idPermisos.equals(other.idPermisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Permiso[ idPermisos=" + idPermisos + " ]";
    }
    
}
