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
 * @author danie
 */
@Entity
@Table(name = "emails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e")
    , @NamedQuery(name = "Email.findByIdemails", query = "SELECT e FROM Email e WHERE e.idemails = :idemails")
    , @NamedQuery(name = "Email.findByNombre", query = "SELECT e FROM Email e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Email.findByApellido", query = "SELECT e FROM Email e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Email.findByCorreo", query = "SELECT e FROM Email e WHERE e.correo = :correo")
    , @NamedQuery(name = "Email.findByCorreoDestinatario", query = "SELECT e FROM Email e WHERE e.correoDestinatario = :correoDestinatario")
    , @NamedQuery(name = "Email.findByAsunto", query = "SELECT e FROM Email e WHERE e.asunto = :asunto")
    , @NamedQuery(name = "Email.findByMensaje", query = "SELECT e FROM Email e WHERE e.mensaje = :mensaje")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idemails")
    private Integer idemails;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @Size(max = 45)
    @Column(name = "correoDestinatario")
    private String correoDestinatario;
    @Size(max = 45)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 400)
    @Column(name = "mensaje")
    private String mensaje;
    @JoinColumn(name = "usuarios_documento", referencedColumnName = "documento")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuariosDocumento;

    public Email() {
    }

    public Email(Integer idemails) {
        this.idemails = idemails;
    }

    public Integer getIdemails() {
        return idemails;
    }

    public void setIdemails(Integer idemails) {
        this.idemails = idemails;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreoDestinatario() {
        return correoDestinatario;
    }

    public void setCorreoDestinatario(String correoDestinatario) {
        this.correoDestinatario = correoDestinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        hash += (idemails != null ? idemails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.idemails == null && other.idemails != null) || (this.idemails != null && !this.idemails.equals(other.idemails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigmeyc.entities.Email[ idemails=" + idemails + " ]";
    }
    
}
