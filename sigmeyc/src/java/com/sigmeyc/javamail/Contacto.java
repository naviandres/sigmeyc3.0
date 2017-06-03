/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.javamail;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author ivan
 */
@Named(value = "contacto")
@RequestScoped
public class Contacto {
    
    
    
    
    String nombre;
    String apellido;
    String correo;
    String asunto;
    String mensaje;

  
    public Contacto() {
        
        
    }

    public Contacto(String nombre, String apellido, String correo, String asunto, String mensaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.asunto = asunto;
        this.mensaje = mensaje;
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
    
    
}
