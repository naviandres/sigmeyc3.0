package com.sigmeyc.jsf;

import com.sigmeyc.beans.SolicitudFacade;
import com.sigmeyc.entities.Empresa;
import com.sigmeyc.entities.Usuario;
import com.sigmeyc.entities.Solicitud;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("solicitudController")
@SessionScoped
public class SolicitudController implements Serializable {

    @EJB
    private SolicitudFacade solicitudFacade;
    
    private Solicitud solicitud;

    public SolicitudController() {
    }
    
    @PostConstruct
    public void init(){
        solicitud = new Solicitud();
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    public String guardar() {
        this.solicitudFacade.create(solicitud);
        init();
        return "/crud/solicitud/Create.xhtml?faces-redirect=true";
    }

//    public void foraneaUsuario(){
//        FacesContext context = FacesContext.getCurrentInstance();
//        UsuarioController uc = context.getApplication().evaluateExpressionGet(context, "#{usuarioController}", UsuarioController.class);
//        usuarioscodigoUsuario = (Usuario) uc.getUsuarios();
//    }
    public String prepareCreate() {
        return "/crud/solicitud/Create.xhtml?faces-redirect=true";
    }

    public String prepareView(Solicitud s) {
        this.solicitud = s;
        return "/crud/solicitud/View.xhtml?faces-redirect=true";
    }

    public String prepareList() {
        return "/crud/solicitud/List.xhtml?faces-redirect=true";
    }

    public List<Solicitud> getSolicitudes() {
        return this.solicitudFacade.findAll();
    }

    public String eliminar(Solicitud s) {
        this.solicitudFacade.remove(s);
        return "/crud/solicitud/List.xhtml?faces-redirect=true";
    }

    public String editar(Solicitud s) {
        setSolicitud(s);
        return "/crud/solicitud/Edit.xhtml?faces-redirect=true";
    }

    public String guardarEdicion() {
        this.solicitudFacade.edit(solicitud);
        return "/crud/solicitud/Edit.xhtml?faces-redirect=true";
    }

    public String destruirVer(Integer idSolicitud) {

        return "/crud/solicitud/List.xhtml?faces-redirect=true";
    }

}
