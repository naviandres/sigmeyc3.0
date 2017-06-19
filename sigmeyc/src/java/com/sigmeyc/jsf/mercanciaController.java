package com.sigmeyc.jsf;

import com.sigmeyc.beans.GuiaFacade;
import com.sigmeyc.beans.LocalidadFacade;
import com.sigmeyc.beans.MercanciaFacade;
import com.sigmeyc.beans.PlanillaFacade;
import com.sigmeyc.beans.RutaFacade;
import com.sigmeyc.beans.SolicitudFacade;
import com.sigmeyc.entities.Guia;
import com.sigmeyc.entities.Mercancia;
import com.sigmeyc.entities.Planilla;
import com.sigmeyc.entities.Ruta;
import com.sigmeyc.entities.Solicitud;
import com.sigmeyc.entities.Vehiculo;
import com.sigmeyc.jsf.util.MessageUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
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
    private GuiaFacade guiaFacade;

    @EJB
    private RutaFacade rutaFacade;
    
    @EJB
    private SolicitudFacade solicitudFacade;

    private Mercancia mercancia;

    private Ruta ruta;

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

    public Solicitud getSolicitudContex() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        return (Solicitud) ec.getSessionMap().get("solicitud");
    }

    public void guardar() {
        mercancia.setIdMercancia(null);

        Planilla planillaid = null;
        Vehiculo idVehiculo = null;
        String nombreLoc = getSolicitudContex().getLocalidadesidLocalidad().getNombreLocalidad();
        List<Ruta> rutas = new ArrayList<>();
        for (Ruta ruta1 : rutaFacade.findAll()) {
            rutas.add(ruta1);
        }
        for (Ruta ruta1 : rutas) {
            System.out.println(ruta1.getNombre());
            if (ruta1.getNombre().equals(nombreLoc)) {
                planillaid = ruta1.getPlanillasidPlanilla();
                idVehiculo = ruta1.getVehiculosidVehiculo();
            }
        }
        Solicitud solicitudesidSolicitud = getSolicitudContex();
        if (solicitudesidSolicitud != null) {
            mercancia.setSolicitudesidSolicitud(solicitudesidSolicitud);
            mercancia.setVehiculosidVehiculo(idVehiculo);
            Guia guiaidGuia = new Guia(null, mercancia.getTipoMercancia() + " " + mercancia.getDescripcionMercancia(), planillaid);
            mercancia.setVolumen(mercancia.getLongitud() * mercancia.getAncho() * mercancia.getAltura());
            mercancia.setGuiasnumeroGuia(guiaidGuia);
            this.guiaFacade.create(guiaidGuia);
            this.solicitudFacade.create(solicitudesidSolicitud);
            this.MercanciaFacade.create(mercancia);
            
            
            System.out.println("solici" + solicitudesidSolicitud);
            MessageUtil.enviarMensajeInformacion("mercaIndex", "Registro exitoso.", "Su solicitud sera recogida: "+solicitudesidSolicitud.getFechaRecoleccion());
            init();
            solicitudesidSolicitud = null;
        } else {
            MessageUtil.enviarMensajeInformacion("mercaIndex", "Necesita realizar la solicitud.", "Ingrese en el formulario de solicitud. ");
        }

    }

    public void killSolicitud(Solicitud solicitud) {
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        FacesContext fc = FacesContext.getCurrentInstance();
//        ExternalContext ec = fc.getExternalContext();
//        ec.getSessionMap().get("solicitud");
//                fc.getELContext().
        solicitud = null;

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
