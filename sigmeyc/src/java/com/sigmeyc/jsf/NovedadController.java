package com.sigmeyc.jsf;

import com.sigmeyc.beans.NovedadFacade;
import com.sigmeyc.entities.Novedad;
import com.sigmeyc.jsf.util.MessageUtil;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("novedadController")
@SessionScoped
public class NovedadController implements Serializable {

  

    @EJB
    private NovedadFacade novedadFacade;
    private Novedad novedad;

    public NovedadController() {
    }
    
    @PostConstruct
    public void init(){
        novedad = new Novedad();
        
        
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }
    
 public void guardar() {
         try {
            if (novedad != null) {
                novedad.setIdMercancia(null);
                novedadFacade.create(novedad);
            } else {
                MessageUtil.enviarMensajeError("createNovedad", "Los campos no fueron diligenciados", "Complete los campos requeridos");
            }
        } catch (Exception e) {
            MessageUtil.enviarMensajeError("createNovedad", "No se puede registrar", "Ya existe una novedad");
        }
    }
    
    public String prepareCreate() {
        return "/app/crud/novedad/Create.xthml?faces-redirect=true";
    }
    
    public String prepareView(Novedad l) {
        this.novedad = l;
        return "/app/crud/novedad/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/novedad/List.xthml?faces-redirect=true";
    }

    public List<Novedad> getNovedades() {
        return this.novedadFacade.findAll();
    }

    public String Eliminar(Novedad l) {
        this.novedadFacade.remove(l);
        return "/app/crud/novedad/List.xthml?faces-redirect=true";
    }
    public String Editar(Novedad l) {
        setNovedad(l);
        return "/app/crud/novedad/Edit.xthml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        novedadFacade.edit(novedad);
        return "/app/crud/novedad/List.xthml?faces-redirect=true";
    }
   

}
