package com.sigmeyc.jsf;

import com.sigmeyc.beans.RolFacade;
import com.sigmeyc.beans.UsuarioFacade;
import com.sigmeyc.controllers.session.SessionController;
import com.sigmeyc.entities.Rol;
import com.sigmeyc.entities.Usuario;
import com.sigmeyc.jsf.util.MessageUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @Inject
    private SessionController sc;

    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private RolFacade rolFacade;

    private Usuario usuario;

    public UsuarioController() {
    }

//    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

//    private void recargarUsuarios() {
//        usuarios = usuarioFacade.findAll();
//    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void guardar() {
        try {
            if (usuario != null) {

                usuario.setRoles(new ArrayList<Rol>());
                usuario.getRoles().add(rolFacade.find(1));
                usuario.setEstado(1);
                usuarioFacade.create(usuario);
                init();
                MessageUtil.enviarMensajeInformacion("createUsuario", "Registro satisfactorio", "El usuario se registro correctamente");
                MessageUtil.enviarMensajeInformacion("formPer", "Registro satisfactorio", "El usuario se registro correctamente");
            } else {
                MessageUtil.enviarMensajeError("createUsuario", "No se han dilingenciado los campos", "Complete campos");
                MessageUtil.enviarMensajeError("formPer", "No se han dilingenciado los campos", "Complete campos");
            }
        } catch (Exception e) {
            MessageUtil.enviarMensajeError("createUsuario", "No se puede registrar", "Ya existe un usuario con ese documento");
            MessageUtil.enviarMensajeError("formPer", "No se puede registrar", "Ya existe un usuario con ese documento");
        }
    }

    public String prepareCreate() {
        return "/app/crud/usuario/Create.xhtml?faces-redirect=true";
    }

    public String prepareView(Usuario u) {
        this.usuario = u;
        return "/app/crud/usuario/View.xhtml?faces-redirect=true";
    }

    public String prepareList() {
        this.usuario = null;
        return "/app/crud/usuario/List.xhtml?faces-redirect=true";
    }

    public List<Usuario> getUsuarios() {
        return this.usuarioFacade.findAll();
    }

    public void eliminar() {
        Usuario u = sc.getUsuarioSesion();
        System.out.println("Usuario inicio" + u.getPrimerNombre());
        System.out.println("Eliminar" + usuario.getPrimerNombre());
        if (u.getDocumento().intValue() != usuario.getDocumento()) {
            usuarioFacade.remove(usuario);
        } else {
            MessageUtil.enviarMensajeError("listUsuario", "Error al eliminar.", "No puede eliminarse ud mismo");
        }
//        return "/app/crud/usuario/List.xhtml?faces-redirect=true";
    }

    public String editar(Usuario u) {
        setUsuario(u);
        return "/app/crud/usuario/Edit.xhtml?faces-redirect=true";
    }

    public String guardarEdicion() {
        this.usuarioFacade.edit(usuario);
        return "/app/crud/usuario/List.xhtml?faces-redirect=true";
    }

    public void cambioDeEstado(Usuario u) {
        try {
            if (u.getEstado() == 1) {
                u.setEstado(2);
            } else {
                u.setEstado(1);
            }
            usuarioFacade.edit(u);
            MessageUtil.enviarMensajeInformacion("listUsuario", "Actualización", "Se ha cambiado el estado del usuario.");
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.enviarMensajeErrorGlobal("Error al cambiar el estado del usuario", e.getStackTrace().toString());
        }

    }

    public String getIconUsuarioBloqueo(Usuario u) {
        return (u.getEstado() == 1) ? "unlock" : "lock";
    }
}
