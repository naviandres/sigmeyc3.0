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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanc
 */
@Entity
@Table(name = "cotizaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    , @NamedQuery(name = "Cotizacion.findByIdcotizaciones", query = "SELECT c FROM Cotizacion c WHERE c.idcotizaciones = :idcotizaciones")
    , @NamedQuery(name = "Cotizacion.findByCiudadDestino", query = "SELECT c FROM Cotizacion c WHERE c.ciudadDestino = :ciudadDestino")
    , @NamedQuery(name = "Cotizacion.findByCantidad", query = "SELECT c FROM Cotizacion c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "Cotizacion.findByPeso", query = "SELECT c FROM Cotizacion c WHERE c.peso = :peso")
    , @NamedQuery(name = "Cotizacion.findByValorDeclarado", query = "SELECT c FROM Cotizacion c WHERE c.valorDeclarado = :valorDeclarado")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcotizaciones")
    private Integer idcotizaciones;
    @Size(max = 20)
    @Column(name = "ciudadDestino")
    private String ciudadDestino;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Column(name = "valorDeclarado")
    private Double valorDeclarado;
    @JoinColumn(name = "usuarios_documento", referencedColumnName = "documento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuariosDocumento;

    public Cotizacion() {
    }

    public Cotizacion(Integer idcotizaciones) {
        this.idcotizaciones = idcotizaciones;
    }

    public Integer getIdcotizaciones() {
        return idcotizaciones;
    }

    public void setIdcotizaciones(Integer idcotizaciones) {
        this.idcotizaciones = idcotizaciones;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(Double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public Usuario getUsuariosDocumento() {
        return usuariosDocumento;
    }

    public void setUsuariosDocumento(Usuario usuariosDocumento) {
        this.usuariosDocumento = usuariosDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcotizaciones != null ? idcotizaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idcotizaciones == null && other.idcotizaciones != null) || (this.idcotizaciones != null && !this.idcotizaciones.equals(other.idcotizaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Cotizacion[ idcotizaciones=" + idcotizaciones + " ]";
    }
    
}
