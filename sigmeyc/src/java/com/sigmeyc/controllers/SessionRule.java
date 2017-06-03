/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.controllers;

import com.sigmeyc.beans.UsuarioFacade;
import com.sigmeyc.entities.Rol;
import com.sigmeyc.entities.Usuario;
import com.sigmeyc.jsf.util.MessageUtil;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ivan
 */
@Stateless
public class SessionRule {

    @EJB
    private UsuarioFacade usuarioFacade;
    
    public Usuario loginUsuario(String email,String clave){
        Usuario u = null;
        if (email != null && email.length() >0 && 
                clave != null && clave.length()>0) {
            u = usuarioFacade.login(email, clave);
            if (u != null) {
                if (u.getEstado()==2) {
                    u=null;
                    MessageUtil.enviarMensajeErrorGlobal("Usuario bloqueado", "Contacte al administrador");
                }
            }else{
                MessageUtil.enviarMensajeErrorGlobal("Datos incorrectos", "Vuelva a intentar");
            }
        }else{
            MessageUtil.enviarMensajeErrorGlobal("Datos obligatorios", "Ingrese email y clave");
        }
        return u;
    }
    
    public Rol validarRol(Usuario u){
        Rol r = null;
        if (u.getRoles()!= null && u.getRoles().size()>0) {
            r=u.getRoles().get(0);
        }else{
            MessageUtil.enviarMensajeErrorGlobal("Rol no asignado", "Debe esperar a que le asignen rol");
        }
        return r;
    }
}
