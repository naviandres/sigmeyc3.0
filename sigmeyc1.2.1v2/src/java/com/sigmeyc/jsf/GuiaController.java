package com.sigmeyc.jsf;

import com.sigmeyc.beans.GuiaFacade;
import com.sigmeyc.entities.Guia;
import com.sigmeyc.entities.Planilla;
import com.sigmeyc.jsf.util.MessageUtil;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named("guiaController")
@SessionScoped
public class GuiaController implements Serializable {

    @EJB
    private GuiaFacade guiaFacade;

    private Guia guia;

    private int numeroGuiaB;

    public GuiaController() {
    }

    @PostConstruct
    public void init() {
        guia = new Guia();
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    public int getNumeroGuiaB() {
        return numeroGuiaB;
    }

    public void setNumeroGuiaB(int numeroGuiaB) {
        this.numeroGuiaB = numeroGuiaB;
    }

    public String buscarGuia() {

        try {
            if (numeroGuiaB != 0) {
                guia = guiaFacade.find(numeroGuiaB);
                return "/app/crud/guia/detallenvio.xhtml?faces-redirect=true";
            } else {
                MessageUtil.enviarMensajeInformacion("formConsul", "Dato incorrecto", "No se encuentra");

            }
        } catch (Exception e) {
            MessageUtil.enviarMensajeInformacion("formConsul", "guia no encontrada", "");

        }
        return "";
    }
public String buscarGuiaRe() {

        try {
            if (numeroGuiaB != 0) {
                guia = guiaFacade.find(numeroGuiaB);
                return "/app/crud/guia/View.xhtml?faces-redirect=true";
            } else {
                MessageUtil.enviarMensajeInformacion("formConsul", "Dato incorrecto", "No se encuentra");

            }
        } catch (Exception e) {
            MessageUtil.enviarMensajeInformacion("formConsul", "guia no encontrada", "");

        }
        return "";
    }
    public String guardar() {
        guia.setNumeroGuia(null);
        this.guiaFacade.create(guia);
        init();
        return "/app/crud/guia/Create.xhtml?faces-redirect=true";
    }

    public String prepareCreate() {
        return "/app/crud/guia/Create.xhtml?faces-redirect=true";
    }

    public String prepareView(Guia g) {
        this.guia = g;
        return "/app/crud/guia/View.xhtml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/guia/List.xhtml?faces-redirect=true";
    }

    public List<Guia> getGuias() {
        return this.guiaFacade.findAll();
    }

    public String Eliminar(Guia g) {
        this.guiaFacade.remove(g);
        return "/app/crud/guia/List.xhtml?faces-redirect=true";
    }

    public String Editar(Guia g) {
        setGuia(g);
        return "/app/crud/guia/Edit.xhtml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        guiaFacade.edit(guia);
        return "/app/crud/guia/List.xhtml?faces-redirect=true";
    }

}
