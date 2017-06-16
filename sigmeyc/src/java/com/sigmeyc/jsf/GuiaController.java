package com.sigmeyc.jsf;

import com.sigmeyc.beans.GuiaFacade;
import com.sigmeyc.entities.Guia;
import com.sigmeyc.entities.Planilla;

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

//    private Integer idGuia;
//    private String codigoBarras;
//    private String detalleMercancia;
//    private Planilla planillasidPlanilla;
    @EJB
    private GuiaFacade guiaFacade;

    private Guia guia;

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

//    public GuiaController(Integer idGuia, String codigoBarras, String detalleMercancia, Planilla planillasidPlanilla) {
//        this.idGuia = idGuia;
//        this.codigoBarras = codigoBarras;
//        this.detalleMercancia = detalleMercancia;
//        this.planillasidPlanilla = planillasidPlanilla;
//    }
//    public Integer getIdGuia() {
//        return idGuia;
//    }
//
//    public void setIdGuia(Integer idGuia) {
//        this.idGuia = idGuia;
//    }
//
//    public String getCodigoBarras() {
//        return codigoBarras;
//    }
//
//    public void setCodigoBarras(String codigoBarras) {
//        this.codigoBarras = codigoBarras;
//    }
//
//    public String getDetalleMercancia() {
//        return detalleMercancia;
//    }
//
//    public Planilla getPlanillasidPlanilla() {
//        return planillasidPlanilla;
//    }
//
//    public void setPlanillasidPlanilla(Planilla planillasidPlanilla) {
//        this.planillasidPlanilla = planillasidPlanilla;
//    }
//
//    public void setDetalleMercancia(String detalleMercancia) {
//        this.detalleMercancia = detalleMercancia;
//    }
//    public String guardar() {
//        Guia g = new Guia(null, codigoBarras, detalleMercancia, planillasidPlanilla);
//        this.guiaFacade.create(g);
////        planillasidPlanilla = new Planilla(null, "333", 212, "fdsd");
//        return "Create";
//    }
    public String guardar() {
        guia.setIdGuia(null);
        this.guiaFacade.create(guia);
        init();
        return "/app/crud/guia/Create.xhtml?faces-redirect=true";
    }

//    public void foraneaGuia() {
//        FacesContext fc = FacesContext.getCurrentInstance();
//
//    }
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
