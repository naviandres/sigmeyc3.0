package com.sigmeyc.jsf;

import com.sigmeyc.beans.EmpresaFacade;
import com.sigmeyc.beans.RolFacade;
import com.sigmeyc.beans.UsuarioFacade;
import com.sigmeyc.entities.Empresa;
import com.sigmeyc.entities.Rol;
import com.sigmeyc.entities.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("empresaController")
@SessionScoped
public class EmpresaController implements Serializable {

    @EJB
    private EmpresaFacade empresaFacade;

    private Empresa empresa;

    @EJB
    private UsuarioFacade usuarioFacade;

    private Usuario usuario;

    @EJB
    private RolFacade rolFacade;

    public EmpresaController() {
    }

    @PostConstruct
    public void init() {
        empresa = new Empresa();
        usuario = new Usuario();

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String guardar() {

        usuario.setRoles(new ArrayList<Rol>());
        usuario.getRoles().add(rolFacade.find(1));
        usuario.setEstado(1);
        usuario.setTipoIdentificacion("empresa");
        usuario.setPrimerNombre("empresa");
        usuario.setPrimerApellido("empresa");

        empresa.setNit(usuario.getDocumento());
        System.out.println("Usuario" + usuario);
        empresa.setUsuario(usuario);

        this.usuarioFacade.create(usuario);
        this.empresaFacade.create(empresa);

        init();

        return "/app/crud/empresa/Create.xthml?faces-redirect=true";
    }

    public String prepareCreate() {
        return "/app/crud/empresa/Create.xthml?faces-redirect=true";
    }

    public String prepareView(Empresa l) {
        this.empresa = l;
        return "/app/crud/empresa/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/empresa/List.xthml?faces-redirect=true";
    }

    public List<Empresa> getEmpresas() {
        return this.empresaFacade.findAll();
    }

    public String eliminar(Empresa l) {
        this.empresaFacade.remove(l);
        return "/app/crud/empresa/List.xthml?faces-redirect=true";
    }

    public String editar(Empresa l) {
//        setUsuario(u);
        setEmpresa(l);
        return "/app/crud/empresa/Edit.xthml?faces-redirect=true";
    }

    public String guardarEdicion() {
//        usuarioFacade.edit(usuario);
        empresaFacade.edit(empresa);
        return "/app/crud/empresa/List.xthml?faces-redirect=true";
    }

}
