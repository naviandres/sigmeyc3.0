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
@Table(name = "mercancias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mercancia.findAll", query = "SELECT m FROM Mercancia m")
    , @NamedQuery(name = "Mercancia.findByCodigoMercancia", query = "SELECT m FROM Mercancia m WHERE m.codigoMercancia = :codigoMercancia")
    , @NamedQuery(name = "Mercancia.findByValorDeclarado", query = "SELECT m FROM Mercancia m WHERE m.valorDeclarado = :valorDeclarado")
    , @NamedQuery(name = "Mercancia.findByTipoMercancia", query = "SELECT m FROM Mercancia m WHERE m.tipoMercancia = :tipoMercancia")
    , @NamedQuery(name = "Mercancia.findByPeso", query = "SELECT m FROM Mercancia m WHERE m.peso = :peso")
    , @NamedQuery(name = "Mercancia.findByLongitud", query = "SELECT m FROM Mercancia m WHERE m.longitud = :longitud")
    , @NamedQuery(name = "Mercancia.findByAncho", query = "SELECT m FROM Mercancia m WHERE m.ancho = :ancho")
    , @NamedQuery(name = "Mercancia.findByAltura", query = "SELECT m FROM Mercancia m WHERE m.altura = :altura")
    , @NamedQuery(name = "Mercancia.findByVolumen", query = "SELECT m FROM Mercancia m WHERE m.volumen = :volumen")
    , @NamedQuery(name = "Mercancia.findByCantidad", query = "SELECT m FROM Mercancia m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "Mercancia.findByEmbalaje", query = "SELECT m FROM Mercancia m WHERE m.embalaje = :embalaje")})
public class Mercancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoMercancia")
    private Integer codigoMercancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorDeclarado")
    private double valorDeclarado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoMercancia")
    private String tipoMercancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private double peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private double longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ancho")
    private double ancho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altura")
    private double altura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumen")
    private double volumen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "embalaje")
    private String embalaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mercanciascodigoMercancia", fetch = FetchType.LAZY)
    private List<Novedad> novedadList;
    @JoinColumn(name = "departamentos_iddepartamento", referencedColumnName = "idDepartamento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamento departamentosIddepartamento;
    @JoinColumn(name = "guia_codigoBarras", referencedColumnName = "codigoBarras")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Guia guiacodigoBarras;
    @JoinColumn(name = "solicitudes_codigoSolicitud", referencedColumnName = "codigoSolicitud")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Solicitud solicitudescodigoSolicitud;
    @JoinColumn(name = "vehiculos_placaVehiculo", referencedColumnName = "placaVehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo vehiculosplacaVehiculo;

    public Mercancia() {
    }

    public Mercancia(Integer codigoMercancia) {
        this.codigoMercancia = codigoMercancia;
    }

    public Mercancia(Integer codigoMercancia, double valorDeclarado, String tipoMercancia, double peso, double longitud, double ancho, double altura, double volumen, int cantidad, String embalaje) {
        this.codigoMercancia = codigoMercancia;
        this.valorDeclarado = valorDeclarado;
        this.tipoMercancia = tipoMercancia;
        this.peso = peso;
        this.longitud = longitud;
        this.ancho = ancho;
        this.altura = altura;
        this.volumen = volumen;
        this.cantidad = cantidad;
        this.embalaje = embalaje;
    }

    public Integer getCodigoMercancia() {
        return codigoMercancia;
    }

    public void setCodigoMercancia(Integer codigoMercancia) {
        this.codigoMercancia = codigoMercancia;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(String embalaje) {
        this.embalaje = embalaje;
    }

    @XmlTransient
    public List<Novedad> getNovedadList() {
        return novedadList;
    }

    public void setNovedadList(List<Novedad> novedadList) {
        this.novedadList = novedadList;
    }

    public Departamento getDepartamentosIddepartamento() {
        return departamentosIddepartamento;
    }

    public void setDepartamentosIddepartamento(Departamento departamentosIddepartamento) {
        this.departamentosIddepartamento = departamentosIddepartamento;
    }

    public Guia getGuiacodigoBarras() {
        return guiacodigoBarras;
    }

    public void setGuiacodigoBarras(Guia guiacodigoBarras) {
        this.guiacodigoBarras = guiacodigoBarras;
    }

    public Solicitud getSolicitudescodigoSolicitud() {
        return solicitudescodigoSolicitud;
    }

    public void setSolicitudescodigoSolicitud(Solicitud solicitudescodigoSolicitud) {
        this.solicitudescodigoSolicitud = solicitudescodigoSolicitud;
    }

    public Vehiculo getVehiculosplacaVehiculo() {
        return vehiculosplacaVehiculo;
    }

    public void setVehiculosplacaVehiculo(Vehiculo vehiculosplacaVehiculo) {
        this.vehiculosplacaVehiculo = vehiculosplacaVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMercancia != null ? codigoMercancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mercancia)) {
            return false;
        }
        Mercancia other = (Mercancia) object;
        if ((this.codigoMercancia == null && other.codigoMercancia != null) || (this.codigoMercancia != null && !this.codigoMercancia.equals(other.codigoMercancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Mercancia[ codigoMercancia=" + codigoMercancia + " ]";
    }
    
}
