/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.controllers;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


/**
 *
 * @author ivan
 */
@Named(value = "smb")
@SessionScoped
public class SessionManagedBean implements Serializable {

    private String correo;
    private String clave;
    private String mensaje;
    private String repClave;

    /**
     * Creates a new instance of SessionManagedBean
     */
    public SessionManagedBean() {
    }

    public SessionManagedBean(String clave) {
        this.clave = clave;
    }

    @PostConstruct
    public void init() {
        System.out.println("Pasó por el postConstruct");
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return clave;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String clave) {
        this.clave = clave;
    }

    public String getRepContraseña() {
        return repClave;
    }

    public void setRepContraseña(String repClave) {
        this.repClave = repClave;
    }

    public String realizarAccion() {
        if (correo != null && clave != null && !clave.equals("")) {
            if (correo.equals("administrador@gmail.com") && clave.equals("123456789")) {
                mensaje = "Bienvenido administrador " + correo;
                return "app/index.xhtml?faces-redirect=true";
            } else if (correo.equals("cliente@gmail.com") && clave.equals("98764")) {
                mensaje = "Bienvenido estimado cliente " + correo;
                return "index.xhtml?faces-redirect=true";
            } else if (correo.equals("recepcionista@gmail.com") && clave.equals("98765")) {
                mensaje = "Datos correctos, Bienvenido recepcionista" + correo;
                return "app/index.xhtml?faces-redirect=true";
            } else if (correo.equals("operador@gmail.com") && clave.equals("98766")) {
                mensaje = "Datos correctos, Bienvenido operador " + correo;
                return "app/index_operador.xhtml?faces-redirect=true";
            } else {
                mensaje = "Documento y/o clave incorrectos";
            }
        } else {
            mensaje = "Diligencie todos lo campos.";
        }

        System.out.println("Valor de los atributos:");
        System.out.println("Documento: " + this.correo);
        System.out.println("Clave: " + this.clave);
        return "";
    }

    public void validarSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            if (correo.equals("administrador@gmail.com") && clave.equals("123456789")) {
                mensaje = "Datos correctos, Bienvenido administrador " + correo;
            } else if (correo.equals("cliente@gmail.com") && clave.equals("98764")) {
                mensaje = "Datos correctos, Bienvenido estimado cliente " + correo;
            } else if (correo.equals("recepcionista@gmail.com") && clave.equals("98765")) {
                mensaje = "Datos correctos, Bienvenido recepcionista " + correo;
            } else if (correo.equals("operador@gmail.com") && clave.equals("98766")) {
                mensaje = "Datos correctos, Bienvenido operador " + correo;
            } else {
                ec.redirect(ec.getRequestContextPath() + "/xhtml/index.xhtml?xhtml-redirect=true");
                mensaje = "Documento y/o clave incorrectos";
            }
        } catch (IOException ex) {
            Logger.getLogger(SessionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public boolean activarBoton() {
//        if (correo != null && clave != null && !clave.equals("")) {
//            if (correo.equals("cliente@gmail.com") && clave.equals("98764")) {
//                return true;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
//            }
//        }
//        return false;
//    }
    
     
    
}
