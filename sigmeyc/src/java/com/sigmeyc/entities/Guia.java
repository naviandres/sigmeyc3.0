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
import javax.persistence.Lob;
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
@Table(name = "guia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guia.findAll", query = "SELECT g FROM Guia g")
    , @NamedQuery(name = "Guia.findByCodigoBarras", query = "SELECT g FROM Guia g WHERE g.codigoBarras = :codigoBarras")
    , @NamedQuery(name = "Guia.findByDetalleMercancia", query = "SELECT g FROM Guia g WHERE g.detalleMercancia = :detalleMercancia")
    , @NamedQuery(name = "Guia.findByDireccionDeEnvio", query = "SELECT g FROM Guia g WHERE g.direccionDeEnvio = :direccionDeEnvio")
    , @NamedQuery(name = "Guia.findByConductorAsignado", query = "SELECT g FROM Guia g WHERE g.conductorAsignado = :conductorAsignado")
    , @NamedQuery(name = "Guia.findByVehiculoDesignado", query = "SELECT g FROM Guia g WHERE g.vehiculoDesignado = :vehiculoDesignado")})
public class Guia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoBarras")
    private Integer codigoBarras;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "detalleMercancia")
    private String detalleMercancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccionDeEnvio")
    private String direccionDeEnvio;
    @Size(max = 45)
    @Column(name = "conductorAsignado")
    private String conductorAsignado;
    @Size(max = 45)
    @Column(name = "vehiculoDesignado")
    private String vehiculoDesignado;
    @JoinColumn(name = "planillas_codigoPlanilla1", referencedColumnName = "codigoPlanilla")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Planilla planillascodigoPlanilla1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guiacodigoBarras", fetch = FetchType.LAZY)
    private List<Mercancia> mercanciaList;

    public Guia() {
    }

    public Guia(Integer codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Guia(Integer codigoBarras, String serial, String detalleMercancia, String direccionDeEnvio) {
        this.codigoBarras = codigoBarras;
        this.serial = serial;
        this.detalleMercancia = detalleMercancia;
        this.direccionDeEnvio = direccionDeEnvio;
    }

    public Integer getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Integer codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDetalleMercancia() {
        return detalleMercancia;
    }

    public void setDetalleMercancia(String detalleMercancia) {
        this.detalleMercancia = detalleMercancia;
    }

    public String getDireccionDeEnvio() {
        return direccionDeEnvio;
    }

    public void setDireccionDeEnvio(String direccionDeEnvio) {
        this.direccionDeEnvio = direccionDeEnvio;
    }

    public String getConductorAsignado() {
        return conductorAsignado;
    }

    public void setConductorAsignado(String conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }

    public String getVehiculoDesignado() {
        return vehiculoDesignado;
    }

    public void setVehiculoDesignado(String vehiculoDesignado) {
        this.vehiculoDesignado = vehiculoDesignado;
    }

    public Planilla getPlanillascodigoPlanilla1() {
        return planillascodigoPlanilla1;
    }

    public void setPlanillascodigoPlanilla1(Planilla planillascodigoPlanilla1) {
        this.planillascodigoPlanilla1 = planillascodigoPlanilla1;
    }

    @XmlTransient
    public List<Mercancia> getMercanciaList() {
        return mercanciaList;
    }

    public void setMercanciaList(List<Mercancia> mercanciaList) {
        this.mercanciaList = mercanciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoBarras != null ? codigoBarras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia)) {
            return false;
        }
        Guia other = (Guia) object;
        if ((this.codigoBarras == null && other.codigoBarras != null) || (this.codigoBarras != null && !this.codigoBarras.equals(other.codigoBarras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Guia[ codigoBarras=" + codigoBarras + " ]";
    }
    
}
