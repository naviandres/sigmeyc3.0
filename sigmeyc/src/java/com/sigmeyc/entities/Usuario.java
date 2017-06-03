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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author ivan
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByTipoIdentificacion", query = "SELECT u FROM Usuario u WHERE u.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "Usuario.findByDocumento", query = "SELECT u FROM Usuario u WHERE u.documento = :documento")
    , @NamedQuery(name = "Usuario.findByPrimerNombre", query = "SELECT u FROM Usuario u WHERE u.primerNombre = :primerNombre")
    , @NamedQuery(name = "Usuario.findBySegundoNombre", query = "SELECT u FROM Usuario u WHERE u.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Usuario.findByPrimerApellido", query = "SELECT u FROM Usuario u WHERE u.primerApellido = :primerApellido")
    , @NamedQuery(name = "Usuario.findBySegundoApellido", query = "SELECT u FROM Usuario u WHERE u.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByCelular", query = "SELECT u FROM Usuario u WHERE u.celular = :celular")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")
    , @NamedQuery(name = "Usuario.findLogin", query = "SELECT u FROM Usuario u WHERE u.email = :ema AND u.clave = :clv")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipoIdentificacion")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "documento")
    private long documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "primerNombre")
    private String primerNombre;
    @Size(max = 45)
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Size(max = 45)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "celular")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email; 
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "clave")
    private String clave;
    @Column(name = "estado")
    private int estado;
    
    @JoinTable(name = "usuarios_has_roles", joinColumns = {
        @JoinColumn(name = "usuarios_idUsuario", referencedColumnName = "idUsuario")}, inverseJoinColumns = {
        @JoinColumn(name = "roles_identificadorRol", referencedColumnName = "identificadorRol")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidUsuario", fetch = FetchType.LAZY)
    private List<Solicitud> solicitudList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidUsuario", fetch = FetchType.LAZY)
    private List<Empresa> empresaList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String tipoIdentificacion, long documento, String primerNombre, String primerApellido, String celular, String email, String clave) {
        this.idUsuario = idUsuario;
        this.tipoIdentificacion = tipoIdentificacion;
        this.documento = documento;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.celular = celular;
        this.email = email;
        this.clave = clave;
    }

    public Usuario(Integer idUsuario, String tipoIdentificacion, long documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, 
            String telefono, String celular, String email, String clave, int estado) {
        this.idUsuario = idUsuario;
        this.tipoIdentificacion = tipoIdentificacion;
        this.documento = documento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.clave = clave;
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    

    @XmlTransient
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }

}
