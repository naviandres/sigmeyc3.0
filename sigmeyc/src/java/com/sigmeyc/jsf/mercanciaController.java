package com.sigmeyc.jsf;

import com.sigmeyc.beans.GuiaFacade;
import com.sigmeyc.beans.MercanciaFacade;
import com.sigmeyc.beans.PlanillaFacade;
import com.sigmeyc.beans.RutaFacade;
import com.sigmeyc.entities.Guia;
import com.sigmeyc.entities.Mercancia;
import com.sigmeyc.entities.Planilla;
import com.sigmeyc.entities.Ruta;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ivan
 */
@Named(value = "mercanciaController")
@SessionScoped
public class mercanciaController implements Serializable {

    /**
     * Creates a new instance of mercanciaController
     */
    @EJB
    private MercanciaFacade MercanciaFacade;
    @EJB
    private PlanillaFacade planillaFacade;
    @EJB
    private GuiaFacade guiaFacade;

    private Mercancia mercancia;

    private Ruta ruta;

    private SolicitudController sc;

    public mercanciaController() {
    }

    @PostConstruct
    public void init() {
        mercancia = new Mercancia();

    }

    public Mercancia getMercancia() {
        return mercancia;
    }

    public void setMercancia(Mercancia mercancia) {
        this.mercancia = mercancia;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public void guardar() {
        mercancia.setIdMercancia(null);
//        System.out.println("iddd"+ sc.getSolicitudContex().getIdSolicitud());

        String loca = mercancia.getLocalidadesidLocalidad().getNombreLocalidad();
        Planilla planillaid = null;
        System.out.println("locas"+loca);
        if (loca.equals("chapinero")) {
             planillaid = planillaFacade.find(1);
        }else if (loca.equals("bosa")) {
            planillaid = planillaFacade.find(2);
        }

        Guia guiaidGuia = new Guia(null, "778", mercancia.getTipoMercancia() + " " + mercancia.getDescripcionMercancia(), planillaid);//cambiar id
        mercancia.setGuiaidGuia(guiaidGuia);
        this.guiaFacade.create(guiaidGuia);
        this.MercanciaFacade.create(mercancia);
        init();
    }

    public String prepareCreate() {
        return "/app/crud/mercancia/Create.xthml?faces-redirect=true";
    }

    public String prepareView(Mercancia l) {
        this.mercancia = l;
        return "/app/crud/mercancia/View.xthml?faces-redirect=true";
    }

    public String prepareList() {
        return "/app/crud/mercancia/List.xthml?faces-redirect=true";
    }

    public List<Mercancia> getMercancias() {
        return this.MercanciaFacade.findAll();
    }

    public String eliminar(Mercancia l) {
        this.MercanciaFacade.remove(l);
        return "/app/crud/mercancia/List.xthml?faces-redirect=true";
    }

    public String editar(Mercancia l) {
        setMercancia(l);
        return "/app/crud/mercancia/Edit.xthml?faces-redirect=true";
    }

    public String guardarEdicion() {
        MercanciaFacade.edit(mercancia);
        return "/app/crud/mercancia/List.xthml?faces-redirect=true";
    }

    public void modal(Mercancia l) {
        this.mercancia = l;
    }

    public String detalle(Mercancia mer) {
        this.mercancia = mer;
        return "/app/operador/detalledeguia.xthml?faces-redirect=true";
    }

}
