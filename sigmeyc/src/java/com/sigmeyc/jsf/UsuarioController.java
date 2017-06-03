package com.sigmeyc.jsf;

import com.sigmeyc.beans.UsuarioFacade;
import com.sigmeyc.entities.Usuario;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacade UsuarioFacade;
    private Usuario usuario;

    public UsuarioController() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String guardar() {
        this.UsuarioFacade.create(usuario);
        init();
        return "/crud/usuario/Create.xthml?faces-redirect=true";
    }

    public String prepareCreate() {
        return "/crud/usuario/Create.xthml?faces-redirect=true";
    }

    public String prepareView(Usuario l) {
        this.usuario = l;
        return "/crud/usuario/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/crud/usuario/List.xthml?faces-redirect=true";
    }

    public List<Usuario> getUsuarios() {
        return this.UsuarioFacade.findAll();
    }

    public String Eliminar(Usuario l) {
        this.UsuarioFacade.remove(l);
        return "/crud/usuario/List.xthml?faces-redirect=true";
    }

    public String Editar(Usuario l) {
        setUsuario(l);
        return "/crud/usuario/Edit.xthml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        UsuarioFacade.edit(usuario);
        return "/crud/usuario/List.xthml?faces-redirect=true";
    }

}
