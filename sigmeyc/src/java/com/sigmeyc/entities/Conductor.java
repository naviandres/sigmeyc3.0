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
@Table(name = "conductores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c")
    , @NamedQuery(name = "Conductor.findByIdConductor", query = "SELECT c FROM Conductor c WHERE c.idConductor = :idConductor")
    , @NamedQuery(name = "Conductor.findByIdentificacionConductor", query = "SELECT c FROM Conductor c WHERE c.identificacionConductor = :identificacionConductor")
    , @NamedQuery(name = "Conductor.findByTipoLicencia", query = "SELECT c FROM Conductor c WHERE c.tipoLicencia = :tipoLicencia")
    , @NamedQuery(name = "Conductor.findByNumeroLicencia", query = "SELECT c FROM Conductor c WHERE c.numeroLicencia = :numeroLicencia")})
public class Conductor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConductor")
    private Integer idConductor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacionConductor")
    private long identificacionConductor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "tipoLicencia")
    private String tipoLicencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroLicencia")
    private long numeroLicencia;
    @JoinColumn(name = "vehiculos_idVehiculo", referencedColumnName = "idVehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo vehiculosidVehiculo;

    public Conductor() {
    }

    public Conductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Conductor(Integer idConductor, long identificacionConductor, String tipoLicencia, long numeroLicencia) {
        this.idConductor = idConductor;
        this.identificacionConductor = identificacionConductor;
        this.tipoLicencia = tipoLicencia;
        this.numeroLicencia = numeroLicencia;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public long getIdentificacionConductor() {
        return identificacionConductor;
    }

    public void setIdentificacionConductor(long identificacionConductor) {
        this.identificacionConductor = identificacionConductor;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public long getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(long numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Vehiculo getVehiculosidVehiculo() {
        return vehiculosidVehiculo;
    }

    public void setVehiculosidVehiculo(Vehiculo vehiculosidVehiculo) {
        this.vehiculosidVehiculo = vehiculosidVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConductor != null ? idConductor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.idConductor == null && other.idConductor != null) || (this.idConductor != null && !this.idConductor.equals(other.idConductor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Conductor[ idConductor=" + idConductor + " ]";
    }
    
}
