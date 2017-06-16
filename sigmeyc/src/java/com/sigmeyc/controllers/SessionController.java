/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.controllers;

import com.sigmeyc.beans.UsuarioFacade;
import com.sigmeyc.entities.Permiso;
import com.sigmeyc.entities.Rol;
import com.sigmeyc.entities.Usuario;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author ivan
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    @EJB
    private UsuarioFacade uf;

    @EJB
    private SessionRule sr;

    private String email;
    private String clave;

    private String tipoIdentificacion;
    private long documento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String celular;

    private Rol rol;
    private Usuario usuario ;

    ;

    public SessionController() {

    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Usuario getUsuarioSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        return (Usuario) ec.getSessionMap().get("user");
    }

    public void tomarDatos() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.getSessionMap().put("user", usuario);
        this.documento = getUsuarioSesion().getDocumento();
        this.tipoIdentificacion = getUsuarioSesion().getTipoIdentificacion();
        this.primerNombre = getUsuarioSesion().getPrimerNombre();
        this.segundoNombre = getUsuarioSesion().getSegundoNombre();
        this.primerApellido = getUsuarioSesion().getPrimerApellido();
        this.segundoApellido = getUsuarioSesion().getSegundoApellido();
        this.telefono = getUsuarioSesion().getTelefono();
        this.celular = getUsuarioSesion().getCelular();
        this.email = getUsuarioSesion().getEmail();
    }

    public String iniciarSession() {
        String url = "";
        usuario = sr.loginUsuario(email, clave);
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        if (usuario != null) {
            rol = sr.validarRol(usuario);
            if (rol != null) {
                String ror = (String) rol.getNombreRol();
                tomarDatos();
                if (ror.equals("cliente")) {
                    url = "/index.xhtml?faces-redirect=true";
                } else if (ror.equals("administrador")) {
                    url = "/app/indexadmin.xhtml?faces-redirect=true";
                }else if (ror.equals("operador")) {
                     url = "/app/indexoperador.xhtml?faces-redirect=true";
                }else if (ror.equals("recepcionista")) {
                     url = "/app/indexrecepcionista.xhtml?faces-redirect=true";
                }
            } else {
                usuario = null;
            }
        }
        return url;
    }

    public void actualizar() {
        getUsuarioSesion().setPrimerNombre(primerNombre);
        getUsuarioSesion().setSegundoNombre(segundoNombre);
        getUsuarioSesion().setPrimerApellido(primerApellido);
        getUsuarioSesion().setSegundoApellido(segundoApellido);
        getUsuarioSesion().setTelefono(telefono);
        getUsuarioSesion().setCelular(celular);
        getUsuarioSesion().setEmail(email);
        getUsuarioSesion().setClave(clave);

        uf.edit(getUsuarioSesion());
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuario = null;
        rol = null;
        email = null;
        clave = "";
        return "/index.xhtml?faces-redict=true";
    }

    public Boolean inicioSesion() {
        return (usuario != null);
    }

    public Boolean permiso(String urlRecurso) {
        if (urlRecurso.endsWith("/app/indexadmin.xhtml")) {
            return true;
        }
        for (Permiso p : rol.getPermisos()) {
            if (p.getUrl() != null && urlRecurso.endsWith(p.getUrl())) {
                return true;
            }
        }
        return false;
    }
    
    public String bajar(){

return "<a class=\"page-scroll\" href=\"#services\">Servicios</a>";
    }

    public boolean activarBoton() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        Usuario u = uf.login(email, clave);
        if (email != null && !email.equals("") && clave != null && !clave.equals("")) {
            if (u != null) {
                ec.getSessionMap().put("user", u);
                
                return true;
            }

        }
        return false;
    }

    @PreDestroy
    public void preDestroy() {
        cerrarSesion();
    }

}
/*
menu dinamico
<ui:repet
<u:foreach items=#{session.rolSeleccionado.permisos}
utputText value escape="false": el escape sirve para no mostrasrj el html
si hace una accion en un contralador se utiliza el bootpnLink
o
 */
