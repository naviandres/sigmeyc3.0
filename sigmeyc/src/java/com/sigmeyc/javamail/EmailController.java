/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.javamail;

import com.sigmeyc.beans.EmailFacadeLocal;
import com.sigmeyc.controllers.session.SessionController;
import com.sigmeyc.entities.Email;
import com.sigmeyc.entities.Usuario;
import java.io.Serializable;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "emailController")
@ViewScoped
public class EmailController implements Serializable {

    @EJB
    private EmailFacadeLocal efl;

    private EmailEnvio emailEnvio;

    private Email email;
    private Usuario usuario;
    private String nombre;
    private String apellido;
    private String asunto;
    private String contenido;

    private SessionController scr = new SessionController();

    /**
     * Creates a new instance of EmailController
     */
    public EmailController() {
        emailEnvio = new EmailEnvio();

    }

    @PostConstruct
    public void init() {
        email = new Email();
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public EmailEnvio getEmailEnvio() {
        return emailEnvio;
    }

    public void setEmailEnvio(EmailEnvio emailEnvio) {
        this.emailEnvio = emailEnvio;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

//    public void guardar() {
//        Usuario us = scr.getUsuarioSesion();
//        email.setUsuariosId(us);
//        email.setNombre(scr.getUsuarioSesion().getPrimerNombre());
//        email.setApellido(scr.getUsuarioSesion().getPrimerApellido());
//        email.setCorreo(emailEnvio.getEmailRemitente());
//        email.setCorreoDestinatario(emailEnvio.getEmailDestinatario());
//        email.setAsunto(asunto);
//        email.setMensaje(contenido);
//        this.efl.create(email);
//        init();
//    }
    public void guardar() {
        Usuario us = null;
        if (us == null) {
            email.setNombre(nombre);
            email.setApellido(apellido);
            email.setCorreo(emailEnvio.getEmailRemitente());
            email.setCorreoDestinatario(emailEnvio.getEmailDestinatario());
            email.setAsunto(asunto);
            email.setMensaje(contenido);
//            email.setUsuarioId(usuario);
            this.efl.create(email);
            init();
        } else {
            us = scr.getUsuarioSesion();
            email.setNombre(scr.getUsuarioSesion().getPrimerNombre());
            email.setApellido(scr.getUsuarioSesion().getPrimerApellido());
            email.setCorreo(emailEnvio.getEmailRemitente());
            email.setCorreoDestinatario(emailEnvio.getEmailDestinatario());
            email.setAsunto(asunto);
            email.setMensaje(contenido);
            email.setUsuariosDocumento(us);
            this.efl.create(email);
            init();
        }

    }

    public List<Email> getEmailss() {
        return efl.findAll();
    }

    public String prepareList() {
        return "/app/email/Listar.xhtml?faces-redirect=true";
    }

    public void enviarMensaje() {
        if (emailEnvio.enviar(asunto, contenido)) {
            guardar();

        } else {
            System.out.println("Error al enviar mensaje");
        }

    }

}
