package com.sigmeyc.jsf;

import com.sigmeyc.beans.GuiaFacade;
import com.sigmeyc.beans.LocalidadFacade;
import com.sigmeyc.beans.MercanciaFacade;
import com.sigmeyc.beans.PlanillaFacade;
import com.sigmeyc.beans.PrecioFacade;
import com.sigmeyc.beans.RutaFacade;
import com.sigmeyc.beans.SolicitudFacade;
import com.sigmeyc.entities.Guia;
import com.sigmeyc.entities.Mercancia;
import com.sigmeyc.entities.Planilla;
import com.sigmeyc.entities.Precio;
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
public class MercanciaController implements Serializable {

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

    @EJB
    private PrecioFacade precioFacade;

    private Mercancia mercancia;

    private Ruta ruta;

    public MercanciaController() {
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

    public void asignarPrecio() {
        Double peso = mercancia.getPeso();
        List<Precio> precios = new ArrayList<>();
        for (Precio precio : precioFacade.findAll()) {
            precios.add(precio);
        }
        if (peso == 1) {
            mercancia.setPreciosIdprecios(precios.get(0));
        } else if (peso == 2) {
            mercancia.setPreciosIdprecios(precios.get(1));
        } else if (peso == 3) {
            mercancia.setPreciosIdprecios(precios.get(2));
        } else if (peso == 4) {
            mercancia.setPreciosIdprecios(precios.get(3));
        } else if (peso >4 || peso <=10) {
            mercancia.setPreciosIdprecios(precios.get(4));
        } else if (peso >10 || peso<= 15) {
            mercancia.setPreciosIdprecios(precios.get(6));
        } else if (peso >15 || peso <= 20) {
            mercancia.setPreciosIdprecios(precios.get(7));
        } else if (peso >20 || peso<= 25) {
            mercancia.setPreciosIdprecios(precios.get(8));
        } else if (peso >25 || peso <= 30) {
            mercancia.setPreciosIdprecios(precios.get(9));
        } else if (peso >30 || peso<= 35) {
            mercancia.setPreciosIdprecios(precios.get(10));
        } else if (peso >35 || peso <= 40) {
            mercancia.setPreciosIdprecios(precios.get(11));
        } else if (peso >40 || peso <= 50) {
            mercancia.setPreciosIdprecios(precios.get(12));
        } else if (peso >50 || peso <= 60) {
            mercancia.setPreciosIdprecios(precios.get(13));
        } else if (peso >60 ||peso <= 70) {
            mercancia.setPreciosIdprecios(precios.get(14));
        } else if (peso >70 || peso <= 80) {
            mercancia.setPreciosIdprecios(precios.get(15));
        } else if (peso >80 ||peso <= 90) {
            mercancia.setPreciosIdprecios(precios.get(16));
        } else if (peso >90 ||peso <= 100) {
            mercancia.setPreciosIdprecios(precios.get(17));
        } else if (peso >100 || peso <= 150) {
            mercancia.setPreciosIdprecios(precios.get(18));
        } else {
            MessageUtil.enviarMensajeInformacion("mercaIndex", "No se puede registrar el peso.", "Peso no permitido." );
        }
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
            asignarPrecio();
            this.guiaFacade.create(guiaidGuia);
            this.solicitudFacade.create(solicitudesidSolicitud);
            this.MercanciaFacade.create(mercancia);

            System.out.println("solici" + solicitudesidSolicitud);
            MessageUtil.enviarMensajeInformacion("mercaIndex", "Registro exitoso.", "Su solicitud sera recogida: " + solicitudesidSolicitud.getFechaRecoleccion()+"Su nomero de guia es:"+ mercancia.getGuiasnumeroGuia().getNumeroGuia());

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

    public void guardarEdicion() {
        System.out.println("mercaS"+mercancia.getEstadoMercancia());
        MercanciaFacade.edit(mercancia);
//        return "/app/crud/mercancia/List.xthml?faces-redirect=true";
    }

    public void modal(Mercancia m) {
        setMercancia(m);
    }

    public String detalle(Mercancia mer) {
        this.mercancia = mer;
        return "/app/operador/detalledeguia.xthml?faces-redirect=true";
    }

}
