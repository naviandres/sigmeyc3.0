/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.converter;
import com.sigmeyc.beans.RutaFacade;

import com.sigmeyc.entities.Ruta;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.context.FacesContext;

/**
 *
 * @author juanc
 */
@FacesConverter(forClass = Ruta.class, value = "rutaConverter")
public class RutaConverter implements Converter {
     private RutaFacade rf;

    public RutaConverter() {
        rf = CDI.current().select(RutaFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return rf.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Ruta) {
            Ruta p = (Ruta) value;
            return p.getIdRutas().toString();
        }
        return null;
    }
}
