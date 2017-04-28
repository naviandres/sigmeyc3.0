/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "solicitudes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findByCodigoSolicitud", query = "SELECT s FROM Solicitud s WHERE s.codigoSolicitud = :codigoSolicitud")
    , @NamedQuery(name = "Solicitud.findByTipoServicio", query = "SELECT s FROM Solicitud s WHERE s.tipoServicio = :tipoServicio")
    , @NamedQuery(name = "Solicitud.findByFechaEntrega", query = "SELECT s FROM Solicitud s WHERE s.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Solicitud.findByCiudadDestino", query = "SELECT s FROM Solicitud s WHERE s.ciudadDestino = :ciudadDestino")
    , @NamedQuery(name = "Solicitud.findByDirecci\u00f3nDestino", query = "SELECT s FROM Solicitud s WHERE s.direcci\u00f3nDestino = :direcci\u00f3nDestino")
    , @NamedQuery(name = "Solicitud.findByNombreDestinatario", query = "SELECT s FROM Solicitud s WHERE s.nombreDestinatario = :nombreDestinatario")
    , @NamedQuery(name = "Solicitud.findByApellidoDestinatario", query = "SELECT s FROM Solicitud s WHERE s.apellidoDestinatario = :apellidoDestinatario")
    , @NamedQuery(name = "Solicitud.findByTelefonoDestinatario", query = "SELECT s FROM Solicitud s WHERE s.telefonoDestinatario = :telefonoDestinatario")
    , @NamedQuery(name = "Solicitud.findByPrioridad", query = "SELECT s FROM Solicitud s WHERE s.prioridad = :prioridad")
    , @NamedQuery(name = "Solicitud.findByTiempoEntrega", query = "SELECT s FROM Solicitud s WHERE s.tiempoEntrega = :tiempoEntrega")
    , @NamedQuery(name = "Solicitud.findByFechaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "Solicitud.findByOrigenDeMercancia", query = "SELECT s FROM Solicitud s WHERE s.origenDeMercancia = :origenDeMercancia")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoSolicitud")
    private Integer codigoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoServicio")
    private String tipoServicio;
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ciudadDestino")
    private String ciudadDestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "direcci\u00f3nDestino")
    private String direcciónDestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreDestinatario")
    private String nombreDestinatario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellidoDestinatario")
    private String apellidoDestinatario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefonoDestinatario")
    private String telefonoDestinatario;
    @Size(max = 20)
    @Column(name = "prioridad")
    private String prioridad;
    @Size(max = 15)
    @Column(name = "tiempoEntrega")
    private String tiempoEntrega;
    @Column(name = "fechaSolicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "origenDeMercancia")
    private String origenDeMercancia;
    @JoinColumn(name = "empresas_codigoEmpresa", referencedColumnName = "codigoEmpresa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresascodigoEmpresa;
    @JoinColumn(name = "usuarios_codigoUsuario", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioscodigoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudescodigoSolicitud", fetch = FetchType.LAZY)
    private List<Mercancia> mercanciaList;

    public Solicitud() {
    }

    public Solicitud(Integer codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public Solicitud(Integer codigoSolicitud, String tipoServicio, String ciudadDestino, String direcciónDestino, String nombreDestinatario, String apellidoDestinatario, String telefonoDestinatario, String origenDeMercancia) {
        this.codigoSolicitud = codigoSolicitud;
        this.tipoServicio = tipoServicio;
        this.ciudadDestino = ciudadDestino;
        this.direcciónDestino = direcciónDestino;
        this.nombreDestinatario = nombreDestinatario;
        this.apellidoDestinatario = apellidoDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.origenDeMercancia = origenDeMercancia;
    }

    public Integer getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(Integer codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDirecciónDestino() {
        return direcciónDestino;
    }

    public void setDirecciónDestino(String direcciónDestino) {
        this.direcciónDestino = direcciónDestino;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getApellidoDestinatario() {
        return apellidoDestinatario;
    }

    public void setApellidoDestinatario(String apellidoDestinatario) {
        this.apellidoDestinatario = apellidoDestinatario;
    }

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(String tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getOrigenDeMercancia() {
        return origenDeMercancia;
    }

    public void setOrigenDeMercancia(String origenDeMercancia) {
        this.origenDeMercancia = origenDeMercancia;
    }

    public Empresa getEmpresascodigoEmpresa() {
        return empresascodigoEmpresa;
    }

    public void setEmpresascodigoEmpresa(Empresa empresascodigoEmpresa) {
        this.empresascodigoEmpresa = empresascodigoEmpresa;
    }

    public Usuario getUsuarioscodigoUsuario() {
        return usuarioscodigoUsuario;
    }

    public void setUsuarioscodigoUsuario(Usuario usuarioscodigoUsuario) {
        this.usuarioscodigoUsuario = usuarioscodigoUsuario;
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
        hash += (codigoSolicitud != null ? codigoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.codigoSolicitud == null && other.codigoSolicitud != null) || (this.codigoSolicitud != null && !this.codigoSolicitud.equals(other.codigoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Solicitud[ codigoSolicitud=" + codigoSolicitud + " ]";
    }
    
}
