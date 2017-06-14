/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.converter;

import com.sigmeyc.beans.LocalidadFacade;
import com.sigmeyc.entities.Localidad;
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
@FacesConverter(forClass = Localidad.class, value = "localidadConverter")
public class LocalidadConverter implements Converter {

    private LocalidadFacade localidadFacade;

    public LocalidadConverter() {
        localidadFacade = CDI.current().select(LocalidadFacade.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value != null && value.length() > 0) {
            return localidadFacade.find(Integer.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Localidad) {
            Localidad l = (Localidad) value;
            return l.getIdLocalidad().toString();
        }
        return null;
    }
}
