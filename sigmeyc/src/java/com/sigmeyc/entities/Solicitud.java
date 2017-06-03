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
 * @author ivan
 */
@Entity
@Table(name = "solicitudes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "Solicitud.findByTiempoEntrega", query = "SELECT s FROM Solicitud s WHERE s.tiempoEntrega = :tiempoEntrega")
    , @NamedQuery(name = "Solicitud.findByTipoServicio", query = "SELECT s FROM Solicitud s WHERE s.tipoServicio = :tipoServicio")
    , @NamedQuery(name = "Solicitud.findByDireccionOrigen", query = "SELECT s FROM Solicitud s WHERE s.direccionOrigen = :direccionOrigen")
    , @NamedQuery(name = "Solicitud.findByDireccionDestino", query = "SELECT s FROM Solicitud s WHERE s.direccionDestino = :direccionDestino")
    , @NamedQuery(name = "Solicitud.findByNombreDestinatario", query = "SELECT s FROM Solicitud s WHERE s.nombreDestinatario = :nombreDestinatario")
    , @NamedQuery(name = "Solicitud.findByApellidoDestinatario", query = "SELECT s FROM Solicitud s WHERE s.apellidoDestinatario = :apellidoDestinatario")
    , @NamedQuery(name = "Solicitud.findByTelefonoDestinatario", query = "SELECT s FROM Solicitud s WHERE s.telefonoDestinatario = :telefonoDestinatario")
    , @NamedQuery(name = "Solicitud.findByPriorizacion", query = "SELECT s FROM Solicitud s WHERE s.priorizacion = :priorizacion")
    , @NamedQuery(name = "Solicitud.findByFechaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaSolicitud = :fechaSolicitud")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitud")
    private Integer idSolicitud;
    @Size(max = 15)
    @Column(name = "tiempoEntrega")
    private String tiempoEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoServicio")
    private String tipoServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "direccionOrigen")
    private String direccionOrigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "direccionDestino")
    private String direccionDestino;
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
    @Column(name = "priorizacion")
    private String priorizacion;
    @Column(name = "fechaSolicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @JoinColumn(name = "empresas_idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresasidEmpresa;
    @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuariosidUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudesidSolicitud", fetch = FetchType.LAZY)
    private List<Mercancia> mercanciaList;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(Integer idSolicitud, String tipoServicio, String direccionOrigen, String direccionDestino, String nombreDestinatario, String apellidoDestinatario, String telefonoDestinatario) {
        this.idSolicitud = idSolicitud;
        this.tipoServicio = tipoServicio;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.nombreDestinatario = nombreDestinatario;
        this.apellidoDestinatario = apellidoDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public Solicitud(Integer idSolicitud, String tiempoEntrega, String tipoServicio, String direccionOrigen, String direccionDestino, String nombreDestinatario, String apellidoDestinatario, String telefonoDestinatario, String priorizacion, Date fechaSolicitud, Empresa empresasidEmpresa, Usuario usuariosidUsuario) {
        this.idSolicitud = idSolicitud;
        this.tiempoEntrega = tiempoEntrega;
        this.tipoServicio = tipoServicio;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.nombreDestinatario = nombreDestinatario;
        this.apellidoDestinatario = apellidoDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.priorizacion = priorizacion;
        this.fechaSolicitud = fechaSolicitud;
        this.empresasidEmpresa = empresasidEmpresa;
        this.usuariosidUsuario = usuariosidUsuario;
    }

    

    
    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(String tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
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

    public String getPriorizacion() {
        return priorizacion;
    }

    public void setPriorizacion(String priorizacion) {
        this.priorizacion = priorizacion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Empresa getEmpresasidEmpresa() {
        return empresasidEmpresa;
    }

    public void setEmpresasidEmpresa(Empresa empresasidEmpresa) {
        this.empresasidEmpresa = empresasidEmpresa;
    }

    public Usuario getUsuariosidUsuario() {
        return usuariosidUsuario;
    }

    public void setUsuariosidUsuario(Usuario usuariosidUsuario) {
        this.usuariosidUsuario = usuariosidUsuario;
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
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Solicitud[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
