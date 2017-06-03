package com.sigmeyc.jsf;

import com.sigmeyc.beans.PlanillaFacade;
import com.sigmeyc.entities.Planilla;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named("planillaController")
@SessionScoped
public class PlanillaController implements Serializable {

    @EJB
    private PlanillaFacade planillaFacade;

    private Planilla planilla;

    public PlanillaController() {
    }

    @PostConstruct
    public void init() {
        planilla = new Planilla();
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    public String guardar() {
        this.planillaFacade.create(planilla);
        init();
        return "/crud/planilla/Create.xhtml?faces-redirect=true";
    }
    
    public String prepareCreate() {
        return "/crud/planilla/Create.xhtml?faces-redirect=true";
    }
    
    public String prepareView(Planilla p) {
        this.planilla = p;
        return "/crud/planilla/View.xhtml?faces-redirect=true";
    }

    public String prepareList() {
        return "/crud/planilla/List.xhtml?faces-redirect=true";
    }

    public List<Planilla> getPlanillas() {
        return this.planillaFacade.findAll();
    }

    public String Eliminar(Planilla p) {
        this.planillaFacade.remove(p);
        return "/crud/planilla/List.xhtml?faces-redirect=true";
    }
    public String Editar(Planilla p) {
        setPlanilla(p);
        return "/crud/planilla/Edit.xhtml?faces-redirect=true";
    }

    public String GuardarEdicion() {
        planillaFacade.edit(planilla);
        return "/crud/planilla/Edit.xhtml?faces-redirect=true";
    }


}
