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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "conductores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c")
    , @NamedQuery(name = "Conductor.findByDocumento", query = "SELECT c FROM Conductor c WHERE c.documento = :documento")
    , @NamedQuery(name = "Conductor.findByTipoLicencia", query = "SELECT c FROM Conductor c WHERE c.tipoLicencia = :tipoLicencia")
    , @NamedQuery(name = "Conductor.findByNumeroLicencia", query = "SELECT c FROM Conductor c WHERE c.numeroLicencia = :numeroLicencia")})
public class Conductor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documento")
    private Long documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "tipoLicencia")
    private String tipoLicencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroLicencia")
    private long numeroLicencia;
    @JoinColumn(name = "documento", referencedColumnName = "documento", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @JoinColumn(name = "vehiculos_idVehiculo", referencedColumnName = "idVehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo vehiculosidVehiculo;

    public Conductor() {
    }

    public Conductor(Long documento) {
        this.documento = documento;
    }

    public Conductor(Long documento, String tipoLicencia, long numeroLicencia) {
        this.documento = documento;
        this.tipoLicencia = tipoLicencia;
        this.numeroLicencia = numeroLicencia;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Conductor[ documento=" + documento + " ]";
    }
    
}
