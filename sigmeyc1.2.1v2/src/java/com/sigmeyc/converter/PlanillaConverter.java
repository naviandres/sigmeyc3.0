/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.converter;

import com.sigmeyc.beans.PlanillaFacade;
import com.sigmeyc.entities.Planilla;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ivan
 */
//@Named("planillaConverterBean")
//@ManagedBean() 
@FacesConverter(forClass = Planilla.class, value = "planillaConverter")
public class PlanillaConverter implements Converter {

    private PlanillaFacade pf;

    public PlanillaConverter() {
        pf = CDI.current().select(PlanillaFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return pf.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Planilla) {
            Planilla p = (Planilla) value;
            return p.getIdPlanilla().toString();
        }
        return null;
    }
}
