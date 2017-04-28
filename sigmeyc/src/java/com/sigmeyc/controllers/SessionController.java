/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.controllers;

import com.sigmeyc.beans.UsuarioFacade;
import com.sigmeyc.entities.Rol;
import com.sigmeyc.entities.Usuario;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

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

    private String correo;
    private String clave;
    private Integer rol;

    public SessionController() {

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public UsuarioFacade getUf() {
        return uf;
    }

    public void setUf(UsuarioFacade uf) {
        this.uf = uf;
    }

    public String action() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        FacesMessage msj = new FacesMessage();
        String url = "";
        if (correo != null && !correo.equals("")
                && clave != null && !clave.equals("")) {
            Usuario u = uf.login(correo, clave);
            if (u != null) {
//                usuario
//lista
//rol
//id
// Integer rol = u.getRolList().get(0).getIdentificadorRol();
                List<Rol> roles = u.getRolList();
                for (Rol role : roles) {
                    if (role.getIdentificadorRol() != null) {
                        rol = role.getIdentificadorRol();
                    }
                }
                switch (rol) {
                    case 1:
                        ec.getSessionMap().put("user", u);
                        url = "/index.xhtml?faces-redirect=true";
                        break;
                    case 2:
                        ec.getSessionMap().put("user", u);
                        url = "/app/indexadmin.xhtml?faces-redirect=true";
                        break;
                    case 3:
                        ec.getSessionMap().put("user", u);
                        url = "/app/indexoperador.xhtml?faces-redirect=true";
                        break;
                    case 4:
                        ec.getSessionMap().put("user", u);
                        url = "/app/indexrecepcionista.xhtml?faces-redirect=true";
                        break;
                    default:
                        System.out.println("no se encontro");
                }
            } else {
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos incorrectos", "Compruebe sus datos de acceso.");
            }
        } else {
            msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos incompletos", "Debe diligenciar todos los campos.");
        }
        fc.addMessage(null, msj);
        return url;
    }

    public Usuario getUsuarioSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        return (Usuario) ec.getSessionMap().get("user");
    }

    public boolean activarBoton() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        Usuario u = uf.login(correo, clave);
        if (correo != null && !correo.equals("") && clave != null && !clave.equals("")) {
            if (u != null) {
                ec.getSessionMap().put("user", u);
                return true;
            }

        }
        return false;
    }

//    public void validarSesion() {
//        try {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            ExternalContext ec = fc.getExternalContext();
//            if (getUsuarioSesion() == null) {
//                ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(SessionController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public String cerrarSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.invalidateSession();
        correo = null;
        clave = "";
        return "/index.xhtml?faces-redict=true";
    }
}
